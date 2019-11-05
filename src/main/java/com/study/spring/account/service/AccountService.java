package com.study.spring.account.service;

import com.study.spring.account.dto.AccountCreateDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    Account get(String loginId);

    Account findAccountById(Long id);

    List<Account> getAll();

    void update(Account account, Role role);
//
    void create(AccountCreateDto accountCreateDto);
//
//    void delete(String loginId);

    Page<AccountResDto> findAll(Pageable pageable);

}
