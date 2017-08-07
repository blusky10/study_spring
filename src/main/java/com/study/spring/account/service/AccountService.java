package com.study.spring.account.service;

import com.study.spring.domain.Account;
import com.study.spring.domain.Role;

import java.util.List;

public interface AccountService {
    Account get(String loginId);

    List<Account> getAll();

    void update(String loginId);

    void create(Account account, Role role);

    void updateRole(String loginId);
}
