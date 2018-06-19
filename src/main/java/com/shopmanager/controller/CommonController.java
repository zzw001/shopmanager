package com.shopmanager.controller;

import com.alibaba.fastjson.JSON;
import com.shopmanager.entity.OrderList;
import com.shopmanager.entity.ShopcartList;
import com.shopmanager.model.*;
import com.shopmanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private CatagoryService catagoryService;

    @Autowired
    private SubCataService subCataService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private TransportationService transportationService;

    @Autowired
    private TranInfoService tranInfoService;

    @RequestMapping("/")
    public String index(Model model){
        List<Catagory> catagories = catagoryService.getAll();
        model.addAttribute("catagories",catagories);
        return "index";
    }

    @RequestMapping("/subcata/{cataid}")
    public void getsubcata(@PathVariable("cataid")String cataid, HttpServletResponse response){
        try {
            int id = Integer.parseInt(cataid);
            List<Subcata> subcatas = subCataService.getByCataId(id);
            String data = JSON.toJSONString(subcatas);
            System.out.println(data);
            try {
                response.setContentType("applicataion/json");
                response.getWriter().print(data);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userService.getByUsername(username);
            if(user == null){
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "login";
            }

            if(password.length() ==0){
                String error = "密码不能为空";
                model.addAttribute("error",error);
                return "login";
            }else if(password.equals(user.getUserPassword())){
                List<Catagory> catagories = catagoryService.getAll();
                model.addAttribute("username",username);
                model.addAttribute("catagories",catagories);
                request.getSession().setAttribute("username",username);
                return "index";
            }else {
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            if(username.length() == 0){
                String error = "用户名不能为空";
                model.addAttribute("error",error);
                return "register";
            }else{
                User user1 = userService.getByUsername(username);
                if(user1 != null){
                    String error = "用户名已存在";
                    model.addAttribute("error",error);
                    return "register";
                }
                user.setUserName(username);
            }

            if(password.length() == 0){
                String error = "密码不能为空";
                model.addAttribute("error",error);
                return "register";
            }else{
                user.setUserPassword(password);
            }
            user.setMoney(0);
            userService.add(user);
            List<Catagory> catagories = catagoryService.getAll();
            model.addAttribute("username",username);
            model.addAttribute("catagories",catagories);
            request.getSession().setAttribute("username",username);
            return "index";
        }
        return "register";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "redirect:/";
    }

    @RequestMapping("/subcata/{subid}/products")
    public void getProduct(@PathVariable("subid")String subid,HttpServletResponse response){
        int subcata = Integer.parseInt(subid);
        List<Product> products = productService.getBySubId(subcata);
        String data = JSON.toJSONString(products);
        System.out.println(data);
        try {
            response.setContentType("application/json");
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/search/{search}")
    public void search(@PathVariable("search")String search,HttpServletResponse response){
        try {
            search = URLDecoder.decode(search,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Product> products = productService.getBySearch(search);
        String data = JSON.toJSONString(products);
        try {
            response.setContentType("application/json");
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/product/{proid}")
    public String product(@PathVariable("proid")String proid,HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            int id = Integer.parseInt(proid);
            int number = Integer.parseInt(request.getParameter("number"));
            String username = (String)request.getSession().getAttribute("username");
            if(username == null){
                return "redirect:/login";
            }
            User user = userService.getByUsername(username);
            Product product = productService.getByProId(id);
            if(product.getProStack()>=number){
                product.setProStack(product.getProStack()-number);
                productService.update(product);
                Shopcart shopcart = shopcartService.getShopcart(product.getProId(),user.getUserId());
                if(shopcart == null){
                    Shopcart shopcart1 = new Shopcart();
                    shopcart1.setProId(product.getProId());
                    shopcart1.setUserId(user.getUserId());
                    shopcart1.setBuyNum(number);
                    shopcart1.setCartState(0);
                    shopcartService.add(shopcart1);
                }else{
                    shopcart.setBuyNum(shopcart.getBuyNum()+number);
                    shopcartService.update(shopcart);
                }
                return "redirect:/shopcart";
            }
        }else{
            int id = Integer.parseInt(proid);
            Product product = productService.getByProId(id);
            model.addAttribute("product",product);
        }
        return "product";
    }

    @RequestMapping("/shopcart")
    public String shopcart(HttpServletRequest request,Model model){
        String username = (String) request.getSession().getAttribute("username");
        if(username == null){
            return "redirect:/login";
        }
        User user = userService.getByUsername(username);
        List<Shopcart> shopcarts = shopcartService.getNotBuyByUserId(user.getUserId());
        List<ShopcartList> shopcartLists = new ArrayList<>();
        for(Shopcart shopcart : shopcarts){
            ShopcartList shopcartList = new ShopcartList();
            Product product = productService.getByProId(shopcart.getProId());
            shopcartList.setCartid(shopcart.getCartId());
            shopcartList.setProid(shopcart.getProId());
            shopcartList.setProname(product.getProName());
            shopcartList.setBuy_num(shopcart.getBuyNum());
            shopcartList.setPrice(product.getProPrice());
            shopcartList.setBuy_price(shopcart.getBuyNum()*product.getProPrice());
            shopcartList.setSize(product.getProSize());
            shopcartLists.add(shopcartList);
        }
        model.addAttribute("shopcarts",shopcartLists);
        return "shopcart";
    }

    @RequestMapping("/shopcart/delete/{cartid}")
    public void shopcart_delete(@PathVariable("cartid")String cartid,HttpServletResponse response){
        int id = Integer.parseInt(cartid);
        int success = shopcartService.delete(id);
        String data = JSON.toJSONString(success);
        response.setContentType("application/json");
        try {
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/shopcart/balance/{cartid}")
    public String shopcart_balance(@PathVariable("cartid")String cartid, HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            String address = request.getParameter("address");
            String code = request.getParameter("code");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String username = (String)request.getSession().getAttribute("username");
            User user = userService.getByUsername(username);
            if(address.length() !=0 && code.length() !=0 && phone.length() !=0 ){
                if(user.getUserPassword().equals(password)){
                    Shopcart shopcart = shopcartService.getByCartid(Integer.parseInt(cartid));
                    Product product = productService.getByProId(shopcart.getProId());
                    if(shopcart.getCartState() == 0){
                        if(user.getMoney()>= shopcart.getBuyNum()*product.getProPrice()){
                            user.setAddress(address);
                            user.setPhone(phone);
                            user.setCode(code);
                            user.setMoney(user.getMoney()-shopcart.getBuyNum()*product.getProPrice());
                            userService.update(user);
                            shopcart.setCartState(1);
                            shopcartService.update(shopcart);
                            return "redirect:/shopcart";
                        }else {
                            String error = "余额不够";
                            model.addAttribute("error",error);
                        }
                    }else{
                        String error = "订单已提交";
                        model.addAttribute("error",error);
                    }
                }else{
                    String error = "密码错误";
                    model.addAttribute("error",error);
                }
            }else {
                String error = "收货地址不能为空";
                model.addAttribute("error",error);
            }
        }
        String username = (String)request.getSession().getAttribute("username");
        User user = userService.getByUsername(username);
        model.addAttribute("user",user);
        Shopcart shopcart = shopcartService.getByCartid(Integer.parseInt(cartid));
        ShopcartList shopcartList = new ShopcartList();
        Product product = productService.getByProId(shopcart.getProId());
        shopcartList.setCartid(shopcart.getCartId());
        shopcartList.setProid(shopcart.getProId());
        shopcartList.setProname(product.getProName());
        shopcartList.setBuy_num(shopcart.getBuyNum());
        shopcartList.setPrice(product.getProPrice());
        shopcartList.setBuy_price(shopcart.getBuyNum()*product.getProPrice());
        shopcartList.setSize(product.getProSize());
        model.addAttribute("shopcart",shopcartList);
        return "balance";
    }

    @RequestMapping("/shopcart/confirm/{cartid}")
    public void confirm(@PathVariable("cartid")String cartid,HttpServletRequest request,HttpServletResponse response){
        String username = (String)request.getSession().getAttribute("username");
        User user = userService.getByUsername(username);
        Shopcart shopcart = shopcartService.getByCartid(Integer.parseInt(cartid));
        Transportation transportation = transportationService.getByCartid(shopcart.getCartId());
        TranInfo tranInfo = new TranInfo();
        tranInfo.setTranId(transportation.getTranId());
        tranInfo.setTranInfoContext(new Date().toString()+": "+user.getUserName() +" 已确认收货");
        tranInfoService.add(tranInfo);
        shopcart.setCartState(4);
        shopcartService.update(shopcart);
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/reset/userinfo")
    public String userinfo(HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String oldpassword = request.getParameter("oldpassword");
            String newpassword = request.getParameter("newpassword");

            String name = (String)request.getSession().getAttribute("username");
            User user = userService.getByUsername(name);
            if(username.length() == 0){
                String error = "用户名不能为空";
                model.addAttribute("error",error);
                return "userinfo";
            }else{
                if(!username.equals(name)){
                    User user1 = userService.getByUsername(username);
                    if(user1 != null){
                        String error = "用户名已存在";
                        model.addAttribute("error",error);
                        return "userinfo";
                    }
                    user.setUserName(username);
                }
            }
            if(!"d41d8cd98f00b204e9800998ecf8427e".equals(oldpassword)){
                if(!user.getUserPassword().equals(oldpassword)){
                    String error = "旧密码不对";
                    model.addAttribute("error",error);
                    return "userinfo";
                }else{
                    if("d41d8cd98f00b204e9800998ecf8427e".equals(newpassword)){
                        String error = "新密码不能为空";
                        model.addAttribute("error",error);
                        return "userinfo";
                    }else{
                        user.setUserPassword(newpassword);
                    }
                }
            }

            userService.update(user);
            request.getSession().setAttribute("username",user.getUserName());
            return "redirect:/profile";
        }else{
            String username = (String)request.getSession().getAttribute("username");
            User user = userService.getByUsername(username);
            model.addAttribute("user",user);
        }
        return "userinfo";
    }

    @RequestMapping("/reset/address")
    public String address(HttpServletRequest request, Model model){
        if("POST".equals(request.getMethod())){
            String username = (String) request.getSession().getAttribute("username");
            User user = userService.getByUsername(username);
            String phone = request.getParameter("phone");
            String code = request.getParameter("code");
            String address = request.getParameter("address");
            user.setPhone(phone);
            user.setCode(code);
            user.setAddress(address);
            userService.update(user);
            return "redirect:/profile";
        }else{
            String username = (String) request.getSession().getAttribute("username");
            User user = userService.getByUsername(username);
            model.addAttribute("user",user);
        }
        return "address";
    }

    @RequestMapping("/order")
    public String order(HttpServletRequest request,Model model){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getByUsername(username);
        List<Shopcart> shopcarts = shopcartService.getBuyByUserId(user.getUserId());
        List<OrderList> orderLists = new ArrayList<>();
        for(Shopcart shopcart : shopcarts){
            OrderList orderList = new OrderList();
            orderList.setCartid(shopcart.getCartId());
            orderList.setBuy_num(shopcart.getBuyNum());
            orderList.setCart_state(shopcart.getCartState());
            Product product = productService.getByProId(shopcart.getProId());
            orderList.setProid(product.getProId());
            orderList.setProname(product.getProName());
            orderList.setPrice(shopcart.getBuyNum()*product.getProPrice());
            orderList.setSize(product.getProSize());
            orderLists.add(orderList);
        }
        model.addAttribute("orders",orderLists);
        return "order";
    }

    @RequestMapping("/transportation/{cartid}")
    public void transportation(@PathVariable("cartid")String cartid,HttpServletResponse response){
        int id = Integer.parseInt(cartid);
        Transportation transportation = transportationService.getByCartid(id);
        if(transportation!=null){
            List<TranInfo> tranInfos = tranInfoService.getByTranId(transportation.getTranId());
            String data = JSON.toJSONString(tranInfos);
            response.setContentType("application/json");
            try {
                response.getWriter().print(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            int empty = 0;
            String data = JSON.toJSONString(empty);
            response.setContentType("application/json");
            try {
                response.getWriter().print(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/topup")
    public String topup(HttpServletRequest request,Model model){
        if("POST".equals(request.getMethod())){
            int money = Integer.parseInt(request.getParameter("money"));
            String password = request.getParameter("password");
            String username = (String) request.getSession().getAttribute("username");
            User user = userService.getByUsername(username);
            if(user.getUserPassword().equals(password)){
                user.setMoney(user.getMoney()+money);
                userService.update(user);
                return "profile";
            }else{
                String error = "密码错误";
                model.addAttribute("error",error);
            }
        }
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getByUsername(username);
        model.addAttribute("user",user);
        return "topup";
    }
}
