package com.study.spring.main.web;

import com.study.spring.authserver.vo.AuthInfo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Map;

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
