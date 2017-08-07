package com.study.spring.role.service;

import com.study.spring.StudySpringApplication;
import com.study.spring.domain.AccountRole;
import com.study.spring.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySpringApplication.class)
public class RoleServieTest {

    @Autowired
    private RoleService roleService;

    @Test
    @Transactional
    public void getRole(){
        Role role = roleService.get((long) 10000);

        List<AccountRole> accountRoles = role.getAccountRoles();

        accountRoles.stream().forEach(
                accountRole -> System.out.println(accountRole.getAccount().getLoingId())
        );
    }

    @Test
    public void update(){
        roleService.update((long) 10001);
    }

}
