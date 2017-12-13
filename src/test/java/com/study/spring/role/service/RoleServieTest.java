package com.study.spring.role.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.account.service.AccountService;
import com.study.spring.auditing.CustomAuditorAware;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class RoleServieTest {

    @Autowired
    private RoleService roleService;

    @MockBean
    private CustomAuditorAware customAuditorAware;

    @Autowired
    private AccountService accountService;

    @Before
    public void setup(){
        Account sessionAccount = accountService.get("admin");
        Mockito.when(customAuditorAware.getCurrentAuditor()).thenReturn(sessionAccount);
    }

    @Test
    public void createRole(){
        Role role = new Role("GUEST", true);
        roleService.create(role);
    }
}
