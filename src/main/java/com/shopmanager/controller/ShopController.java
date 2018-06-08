package com.shopmanager.controller;

import com.shopmanager.model.Manager;
import com.shopmanager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/")
    public String login(HttpServletRequest request, Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Manager user = managerService.getByMananame(username);
            if(user == null){
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "shop/login";
            }
            if(password.length() ==0){
                String error = "密码不能为空";
                model.addAttribute("error",error);
                return "shop/login";
            }else if(password.equals(user.getManaPassword())){
                model.addAttribute("username",username);
                request.getSession().setAttribute("username",username);
                return "shop/index";
            }else {
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "shop/login";
            }
        }
        return "shop/login";
    }
}
