package com.polpid.common.user.web;

import com.polpid.common.user.UserStatus;
import com.polpid.common.user.domain.Users;
import com.polpid.common.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUsers() throws Exception {

        when(userService.findAll())
                .thenReturn(Arrays.asList(
                        Users.builder()
                                .email("test@test.com")
                                .name("test")
                                .status(UserStatus.APPLIED)
                                .build()
                ));

        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("@[0].email").value("test@test.com"));

    }

    @Test
    public void getUser() throws Exception {

        when(userService.findUserById("test@test.com"))
                .thenReturn(
                        Users.builder()
                                .email("test@test.com")
                                .name("test")
                                .status(UserStatus.APPLIED)
                                .build()
                );

        this.mockMvc.perform(get("/users/test@test.com"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUserNotFoundException() throws Exception {

        when(userService.findUserById("test11@test.com"))
                .thenThrow(
                new RuntimeException("User not found")
                );

        this.mockMvc.perform(get("/users/test11@test.com"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
