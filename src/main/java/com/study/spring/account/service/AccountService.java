package com.study.spring.account.service;

import com.study.spring.domain.Account;

import java.util.List;

public interface AccountService {
    Account get(String loginId);

    List<Account> getAll();
}
