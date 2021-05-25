package com.polpid.common.user.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polpid.common.user.UserStatus;
import com.polpid.common.user.domain.Users;
import com.polpid.common.user.service.UserExternalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(UserExternalService.class)
public class UserExternalServiceTest {

    @Autowired
    private MockRestServiceServer server;
    @Autowired
    private UserExternalService userExternalService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findUserByIdTest() throws JsonProcessingException {

        String returnValue = objectMapper.writeValueAsString(Users.builder()
                .email("test@test.com")
                .name("test")
                .status(UserStatus.LOCKED)
            .build());

        server.expect(requestTo("/api/v1/users/test@test.com"))
                .andRespond(withSuccess(returnValue, MediaType.APPLICATION_JSON));

        Users users = userExternalService.findUserById("test@test.com");

        Assert.assertEquals("test@test.com", users.getEmail());

    }
}
