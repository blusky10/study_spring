package com.study.spring.main.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    private static final String LOGIN = "login";
    private static final String ERROR_SESSION = "error/session-expired";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName(LOGIN);
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("accounts", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return modelAndView;
    }

    @RequestMapping(value = "/error/session")
    public ModelAndView error(ModelAndView modelAndView){
        modelAndView.setViewName(ERROR_SESSION);
        return modelAndView;
    }

    @RequestMapping(value = "/oauth")
    public ModelAndView oauth(ModelAndView modelAndView){
        modelAndView.setViewName("oauth");
        return modelAndView;
    }

    @RequestMapping(value = "/googlemap")
    public ModelAndView googlemap(ModelAndView modelAndView){
        modelAndView.setViewName("googlemap");
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
