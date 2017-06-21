package com.study.spring.account.service;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SDS on 2017-06-21.
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(String loginId) {
        return accountRepository.findOne(loginId);
    }
}
