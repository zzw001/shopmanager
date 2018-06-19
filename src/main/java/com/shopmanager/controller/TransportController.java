package com.shopmanager.controller;

import com.alibaba.fastjson.JSON;
import com.shopmanager.entity.OrderList;
import com.shopmanager.entity.TransportList;
import com.shopmanager.model.*;
import com.shopmanager.service.*;
import com.shopmanager.util.ApplicationUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransporterService transporterService;

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private TransportationService transportationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CatagoryService catagoryService;

    @Autowired
    private SubCataService subCataService;

    @Autowired
    private TranInfoService tranInfoService;

    @RequestMapping("/")
    public String login(HttpServletRequest request, Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Transporter user = transporterService.getByTranname(username);
            if(user == null){
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "transport/login";
            }
            if(password.length() ==0){
                String error = "密码不能为空";
                model.addAttribute("error",error);
                return "transport/login";
            }else if(password.equals(user.getTrerPassword())){
                request.getSession().setAttribute("transportname",username);
                return "redirect:/transport/list";
            }else {
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "transport/login";
            }
        }
        return "transport/login";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model){
        List<Shopcart> shopcarts = shopcartService.getAllBuy();
        List<TransportList> transportLists = new ArrayList<>();
        List<Catagory> catagories = catagoryService.getAll();
        List<Subcata> subcatas = subCataService.getAll();
        for(Shopcart shopcart : shopcarts){
            TransportList transportList = new TransportList();
            transportList.setCartid(shopcart.getCartId());
            transportList.setBuy_num(shopcart.getBuyNum());
            transportList.setState(shopcart.getCartState());
            Product product = productService.getByProId(shopcart.getProId());
            transportList.setProid(product.getProId());
            transportList.setProname(product.getProName());
            transportList.setSize(product.getProSize());
            for(Subcata subcata : subcatas){
                if(subcata.getSubId() == product.getSubId()){
                    for(Catagory catagory : catagories){
                        if(catagory.getCataId() == subcata.getCataId()){
                            transportList.setCatagory(catagory.getCataName()+"-"+subcata.getSubName());
                            break;
                        }
                    }
                    break;
                }
            }
            User user = userService.getByUserid(shopcart.getUserId());
            transportList.setUserid(user.getUserId());
            transportList.setUsername(user.getUserName());
            if(shopcart.getCartState() != 1){
                Transportation transportation = transportationService.getByCartid(shopcart.getCartId());
                transportList.setTranid(transportation.getTranId());
            }
            transportLists.add(transportList);
        }
        model.addAttribute("transports",transportLists);
        return "transport/index";
    }

    @RequestMapping("user/{userid}")
    public String user(@PathVariable("userid")String userid,Model model){
        User user = userService.getByUserid(Integer.parseInt(userid));
        model.addAttribute("user",user);
        return "transport/user";
    }

    @RequestMapping("/accept/{cartid}")
    public void accept(@PathVariable("cartid")String cartid, HttpServletRequest request,HttpServletResponse response){
        String tranid = ApplicationUtils.randomUUID();
        Transportation transportation = new Transportation();
        transportation.setCartId(Integer.parseInt(cartid));
        transportation.setTranId(tranid);
        String username = (String) request.getSession().getAttribute("transportname");
        Transporter transporter = transporterService.getByTranname(username);
        transportation.setTrerId(transporter.getTrerId());
        transportationService.add(transportation);
        Shopcart shopcart = shopcartService.getByCartid(Integer.parseInt(cartid));
        shopcart.setCartState(2);
        shopcartService.update(shopcart);
        TranInfo tranInfo = new TranInfo();
        tranInfo.setTranId(tranid);
        Date time = new Date();
        tranInfo.setTranInfoContext(time.toString()+": "+ transporter.getTrerName() +" 接收快递");
        int success = tranInfoService.add(tranInfo);
        String data = JSON.toJSONString(success);
        response.setContentType("application/json");
        try {
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/add/{tranid}")
    public void add(@PathVariable("tranid")String tranid,HttpServletRequest request,HttpServletResponse response){
        System.err.println("aaaa");
        String traninfo = request.getParameter("traninfo");
        String state = request.getParameter("state");
        String cartid = request.getParameter("cartid");
        int cartstate = Integer.parseInt(state);
        Shopcart shopcart = shopcartService.getByCartid(Integer.parseInt(cartid));
        if(cartstate != shopcart.getCartState()){
            shopcart.setCartState(cartstate);
            shopcartService.update(shopcart);
            TranInfo tranInfo = new TranInfo();
            tranInfo.setTranId(tranid);
            if(cartstate == 3){
                String username = (String) request.getSession().getAttribute("transportname");
                Transporter transporter = transporterService.getByTranname(username);
                tranInfo.setTranInfoContext(new Date().toString()+": "+traninfo +" "+transporter.getTrerName()+" 正在派送");
            }else {
                tranInfo.setTranInfoContext(new Date().toString()+": "+traninfo);
            }
            int success = tranInfoService.add(tranInfo);
            String data = JSON.toJSONString(success);
            response.setContentType("application/json");
            try {
                response.getWriter().print(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
