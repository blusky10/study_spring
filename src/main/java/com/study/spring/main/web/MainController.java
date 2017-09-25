package com.study.spring.main.web;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private static final String VIEW_LOGIN = "login";

    @Autowired
    private AccountRepository accoutRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView ingex(ModelAndView modelAndView){
        List<Account> accounts = accoutRepository.findAll();
        modelAndView.setViewName("index");
        modelAndView.addObject("accounts", accounts);

        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }

//    @RequestMapping(value = "/home")
//    public String home(){
//        return "home";
//    }

    @RequestMapping(value = "/private")
    public String privateApi(){
        return "private";
    }
}
