package com.study.spring.main.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String index(){
        return "hello";
    }

    @RequestMapping(value = "/private")
    public String privateApi(){
        return "private";
    }
}
