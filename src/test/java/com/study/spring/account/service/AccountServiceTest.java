package com.study.spring.account.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.auditing.CustomAuditorAware;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import com.study.spring.enums.EnableStatus;
import com.study.spring.role.service.RoleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class AccountServiceTest {

    private static Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);


    @MockBean
    private CustomAuditorAware customAuditorAware;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Before
    public void setup(){
        Account sessionAccount = accountService.get("admin");
        Mockito.when(customAuditorAware.getCurrentAuditor()).thenReturn(sessionAccount);
    }

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

        System.out.println(admin.getEnable().getIntValue());
        Assert.assertEquals(EnableStatus.TRUE, admin.getEnable());
    }

    @Test
    public void createAccount(){
        Account newAccount = new Account();
        newAccount.setLoginId("admin1");
        newAccount.setUsername("admin user");
        newAccount.setPassword("admin1!");
        newAccount.setEmail("admin@spring.com");
        newAccount.setEnable(EnableStatus.TRUE);

        accountService.create(newAccount, null);

        Account account = accountService.get("admin1");
        Assert.assertEquals("admin1", account.getLoginId());
        Assert.assertEquals(EnableStatus.TRUE, account.getEnable());
        Assert.assertNotNull(account.getCreatedBy());
    }

    @Test
    public void updateAccount(){
        Account admin = accountService.get("admin");
        admin.setEmail("admin@spring.com");
        accountService.update(admin, null);

        Account result = accountService.get("admin");
        Assert.assertEquals("admin@spring.com", result.getEmail());
    }

    @Test
    public void createAccountWithRole(){
        Account account = new Account();
        account.setLoginId("admin4");
        account.setUsername("admin4 user");
        account.setPassword("admin4!");
        account.setEmail("admin4@spring.com");
        account.setEnable(EnableStatus.TRUE);

        Role role = roleService.get((long)3);
        accountService.create(account, role);

        Account createAccount = accountService.get("admin4");
        Assert.assertNotNull(createAccount.getRoles());
        Assert.assertTrue((createAccount.getRoles().size() > 0));

        Assert.assertEquals("ADMIN",createAccount.getRoles().get(0).getName());
    }

    @Test
    public void updateWithRole(){
        Account account = accountService.get("admin4");
        account.setRoles(null);

        Role role = roleService.get((long)2);

        accountService.update(account, role);
        Account createAccount = accountService.get("admin4");
        Assert.assertNotNull(createAccount.getRoles());
        Assert.assertTrue((createAccount.getRoles().size() == 1));

        Assert.assertEquals("GUEST",createAccount.getRoles().get(0).getName());
    }

//    @Test
//    public void delete(){
//        accountService.delete("admin1");
//        Assert.assertNull(accountService.get("admin1"));
//    }

}
