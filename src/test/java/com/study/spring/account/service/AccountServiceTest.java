package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.Account;
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

        List<Role> roles = admin.getRoles();

        roles.stream().forEach(
                role -> System.out.println(role.getName())
        );
    }
//
//    @Test
//    public void createAccount(){
//        Account account = new Account();
//        account.setLoingId("admin2");
//        account.setUsername("admin2");
//        account.setPassword("admin12");
//        account.setEnable(true);
//
//        accountService.create(account, null);
//
//        Account account1 = accountService.get("admin2");
//        Assert.assertEquals("admin2", account1.getLoingId());
//    }
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
