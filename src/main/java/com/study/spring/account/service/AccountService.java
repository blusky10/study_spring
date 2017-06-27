package com.study.spring.account.service;

import com.study.spring.domain.Account;

public interface AccountService {
    Account get(String loginId);
}
