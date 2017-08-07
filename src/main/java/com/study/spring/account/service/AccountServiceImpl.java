package com.study.spring.account.service;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.accountRole.repository.AccountRoleRepository;
import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import com.study.spring.domain.Role;
import com.study.spring.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public Account get(String loginId) {
        return accountRepository.findOne(loginId);
    }

    @Override
    public List<Account> getAll() {
        return  accountRepository.findAll();
    }


    /**
     * Account 정보를 Update 한다
     * @param account
     * @param role
     */
    @Override
    public void update(Account account, Role role) {
        if (role != null){
            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(account);
            accountRole.setRole(role);

            account.getAccountRoles().add(accountRole);

            accountRoleRepository.save(accountRole);
        }else{
            accountRepository.save(account);
        }

    }

    /**
     * Account 를 생성한다
     * @param account
     * @param role
     */
    public void create(Account account, Role role){

        accountRepository.save(account);

        if (role != null){
            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(account);
            accountRole.setRole(role);

            accountRoleRepository.save(accountRole);
        }

    }
}
