package com.polpid.common.user.web;

import com.polpid.common.user.UserStatus;
import com.polpid.common.user.domain.Users;
import com.polpid.common.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private Users users;
    @Before
    public void setup(){
        users = Users.builder()
                .email("test@test.com")
                .name("test")
                .status(UserStatus.APPLIED)
                .build();

        userRepository.save(users);
    }

    @Test
    public void getUsers(){
        List<Users> all = userRepository.findAll();
        Assert.assertNotNull(all);
        Assert.assertEquals(1, all.size());
    }

    @Test
    public void getUsersById(){
        Optional<Users> byId = userRepository.findById("test@test.com");
        Assert.assertNotNull(byId);
        Assert.assertEquals("test", byId.get().getName());
    }
}
