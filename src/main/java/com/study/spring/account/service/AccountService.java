package com.study.spring.account.service;

import com.study.spring.domain.Account;

/**
 * Created by SDS on 2017-06-21.
 */
public interface AccountService {
    Account get(String loginId);
}
