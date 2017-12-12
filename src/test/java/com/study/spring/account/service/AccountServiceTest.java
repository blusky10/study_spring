package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import com.study.spring.role.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class AccountServiceTest {

    private static Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Test
    @Transactional
    public void getAccount(){
        Account admin = accountService.get("admin");

        Assert.assertNotNull(admin);
        logger.debug(admin.toString());

        List<Role> roles = admin.getRoles();

        Assert.assertNotNull(roles);

        roles.stream().forEach(
                role -> System.out.println(role.toString())
        );
    }

    @Test
    public void createAccount(){
        Account newAccount = new Account();
        newAccount.setLoginId("admin");
        newAccount.setUsername("admin user");
        newAccount.setPassword("admin1!");
        newAccount.setEmail("admin@spring.com");
        newAccount.setEnable(true);

        accountService.create(newAccount, null);

        Account account = accountService.get("admin");
        Assert.assertEquals("admin", account.getLoginId());
    }
//
//    @Test
//    public void createAccountWithRole(){
//        Account account = new Account();
//        account.setLoingId("admin4");
//        account.setUsername("admin4");
//        account.setPassword("admin13");
//        account.setEnable(true);
//
//        Role role = roleService.get((long)10001);
//        accountService.create(account, role);
//
//        Account account1 = accountService.get("admin4");
//        Assert.assertEquals("admin4", account1.getLoingId());
//    }
//
//    @Test
//    public void updateOnlyAccount(){
//        Account account = accountService.get("admin1");
//        account.setEmail("admin1@test.com");
//        accountService.update(account, null);
//    }
//
//    @Test
//    public void updateWithRole(){
//        Account account = accountService.get("admin1");
//        account.setEmail("admin2@test.com");
//
//        Role role = roleService.get((long)10000);
//
//        accountService.update(account, role);
//    }
//
//    @Test
//    public void delete(){
//        accountService.delete("admin1");
//        Assert.assertNull(accountService.get("admin1"));
//    }

}
