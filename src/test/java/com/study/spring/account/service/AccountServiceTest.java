package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    @Transactional
    public void getAccount(){
        Account admin = accountService.get("admin");

        List<AccountRole> accountRoles = admin.getAccountRoles();

        accountRoles.stream().forEach(
                accountRole -> System.out.println(accountRole.getRole().getName())
        );
    }

    @Test
    public void update(){
        accountService.update("admin");
    }

    @Test
    public void create(){
        Account account = new Account();

        account.setLoingId("admin1");
        account.setUsername("admin1");
        account.setPassword("create!");
        account.setEnable(true);
        accountService.create(account);
    }

    @Test
    public void delete(){
        accountService.updateRole("admin1");
    }
}
