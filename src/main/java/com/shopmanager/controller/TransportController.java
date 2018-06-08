package com.shopmanager.controller;

import com.shopmanager.model.Catagory;
import com.shopmanager.model.Transporter;
import com.shopmanager.model.User;
import com.shopmanager.service.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransporterService transporterService;

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
                model.addAttribute("username",username);
                request.getSession().setAttribute("username",username);
                return "transport/index";
            }else {
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "transport/login";
            }
        }
        return "transport/login";
    }
}
