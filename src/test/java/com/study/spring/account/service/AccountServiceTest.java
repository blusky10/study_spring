package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import com.study.spring.domain.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    @Transactional
    public void getAccount(){
        Account admin = accountService.get("admin");

        AccountRole accountRole = admin.getAccountRoles().get(0);

        Assert.assertNotNull(accountRole);

        Role role = accountRole.getRole();

        Assert.assertNotNull(role);

        Assert.assertEquals("Administrator", role.getName());

    }
}
