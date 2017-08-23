package com.study.spring.role.service;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.account.service.AccountService;
import com.study.spring.domain.Role;
import com.study.spring.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Role get(Long id) {
        return roleRepository.findOne(id);
    }

//    @Override
//    public void update(Long id) {
//        Role role = this.get(id);
//
//        Account account = accountService.get("guest");
//
//        AccountRole accountRole = new AccountRole();
//        accountRole.setAccount(account);
//        accountRole.setRole(role);
////        account.getAccountRoles().add(accountRole);
//
//        accountRoleRepository.save(accountRole);
//        roleRepository.save(role);
//    }
//
//    @Override
//    public void create(Role role, Account account) {
//
//        roleRepository.save(role);
//
//        if (account != null){
//            AccountRole accountRole = new AccountRole();
//            accountRole.setAccount(account);
//            accountRole.setRole(role);
//
//            accountRoleRepository.save(accountRole);
//        }
//
//    }

}
