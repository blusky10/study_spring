package com.study.spring.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    private static final String VIEW_LOGIN = "login";

    @RequestMapping(value = "/")
    public String index(){
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return VIEW_LOGIN;
    }

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/private")
    public String privateApi(){
        return "private";
    }
}
