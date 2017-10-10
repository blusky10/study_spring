package com.study.spring.resourceserver.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceServerController {

    @RequestMapping(value = "/")
    public String privateApi(){
        return "resources";
    }
}
