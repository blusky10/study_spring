package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import com.study.spring.domain.Role;
import com.study.spring.role.service.RoleService;
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

    @Autowired
    private RoleService roleService;

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
    public void updateOnlyAccount(){
        Account account = accountService.get("admin1");
        account.setEmail("admin1@test.com");

        accountService.update(account, null);
    }

    @Test
    @Transactional
    public void updateWithRole(){
        Account account = accountService.get("admin1");
        account.setEmail("admin2@test.com");

        Role role = roleService.get((long)1001);

        accountService.update(account, role);
    }

    @Test
    public void create(){
        Account account = new Account();

        account.setLoingId("admin1");
        account.setUsername("admin1");
        account.setPassword("admin1!");
        account.setEnable(true);

        Role role = roleService.get((long)1000);

        accountService.create(account, role);
    }

}
