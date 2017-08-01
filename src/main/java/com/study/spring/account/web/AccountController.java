package com.study.spring.account.web;

import com.study.spring.account.service.AccountService;
import com.study.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts/{loginId}", method = RequestMethod.GET)
    public Account get(@PathVariable String loginId){
        return accountService.get(loginId);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> get(){
        return accountService.getAll();
    }
}
