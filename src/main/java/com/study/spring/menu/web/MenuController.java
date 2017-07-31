package com.study.spring.menu.web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class MenuController {

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public String getMenus(){

        return "menu";
    }
}
