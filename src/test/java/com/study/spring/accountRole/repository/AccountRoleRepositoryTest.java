package com.study.spring.accountRole.repository;

import com.study.spring.StudySpringApplication;
import com.study.spring.account.repository.AccountRepository;
import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class AccountRoleRepositoryTest {

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findAccount(){

        Account account = new Account();
        account.setLoingId("admin");

        List<AccountRole> accountRoleByAccount = accountRoleRepository.findAccountRoleByAccount(account);


        accountRoleByAccount.stream().forEach(
                accountRole -> System.out.println(accountRole.getRole().getName())
        );
    }

    @Test
    @Transactional
    public void delete(){

        Account account = new Account();
        account.setLoingId("admin1");

        List<AccountRole> accountRoleByAccount = accountRoleRepository.findAccountRoleByAccount(account);
//
//        List<Long> ids  = accountRoleByAccount.stream().map(
//                accountRole -> accountRole.getId()
//        ).collect(Collectors.toList());
//        accountRoleRepository.removeAccountRoleByIdIn(ids);

        accountRoleByAccount.stream().forEach(
                accountRole -> accountRole.setRole(null)
        );

//        AccountRole accountRole = new AccountRole();
//        accountRole.setAccount(account);
//        account.getAccountRoles().removeAll(accountRoleByAccount);
//
//
//        accountRepository.save(account);

        accountRoleRepository.save(accountRoleByAccount);

    }


}
