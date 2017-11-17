package com.study.spring.main.web;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    private static final String VIEW_LOGIN = "login";

    @Autowired
    private AccountRepository accoutRepository;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("accounts", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return modelAndView;
    }

//    @RequestMapping(value = "/home")
//    public String home(){
//        return "home";
//    }

//    @RequestMapping(value = "/private")
//    public String privateApi(){
//        return "private";
//    }
}
