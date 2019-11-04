package com.study.spring.account.service;

import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(String loginId) {
        return accountRepository.findAccountByLoginId(loginId);
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public List<Account> getAll() {
        return  accountRepository.findAll();
    }

    /**
     * Account 를 생성한다
     * @param account
     * @param role
     */
    public void create(Account account, Role role){
        if (role != null){
            account.setRoles(new ArrayList<Role>(Arrays.asList(role)));
        }
        accountRepository.save(account);
    }

    @Override
    public Page<AccountResDto> findAll(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return accounts.map(AccountResDto::new);
    }

    /**
     * Account 정보를 Update 한다
     * @param account
     * @param role
     */
    @Override
    public void update(Account account, Role role) {
        if (role != null){
            account.setRoles(new ArrayList<Role>(Arrays.asList(role)));
        }
        accountRepository.save(account);
    }
//
//    @Override
//    public void delete(String loginId) {
//        accountRepository.delete(loginId);
//    }
}
