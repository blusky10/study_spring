package com.study.spring.account.web;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    public String findAccount(Model model){
        List<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "index";
    }
}
