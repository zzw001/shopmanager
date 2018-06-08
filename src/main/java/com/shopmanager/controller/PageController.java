package com.shopmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/page/404")
    public String error404(){

        return "errors/404";
    }

    @RequestMapping("/page/500")
    public String error500(){

        return "errors/500";
    }
}
