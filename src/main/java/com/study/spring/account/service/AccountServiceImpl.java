package com.study.spring.account.service;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(String loginId) {
        return accountRepository.findOne(loginId);
    }

    @Override
    public List<Account> getAll() {
        return  accountRepository.findAll();
    }
}
