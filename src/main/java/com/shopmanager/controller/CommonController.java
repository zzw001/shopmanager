package com.shopmanager.controller;

import com.alibaba.fastjson.JSON;
import com.shopmanager.model.Catagory;
import com.shopmanager.model.Product;
import com.shopmanager.model.Subcata;
import com.shopmanager.model.User;
import com.shopmanager.service.CatagoryService;
import com.shopmanager.service.ProductService;
import com.shopmanager.service.SubCataService;
import com.shopmanager.service.UserService;
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
    public String product(@PathVariable("proid")String proid,Model model){
        int id = Integer.parseInt(proid);
        Product product = productService.getByProId(id);
        model.addAttribute("product",product);
        return "product";
    }
}
