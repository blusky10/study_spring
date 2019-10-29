package com.study.spring.account.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.spring.account.dto.AccountReqDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountRestController.class)
public class AccountRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    private AccountReqDto reqDto;
    private AccountResDto resDto;

    @Before
    public void setup(){

        reqDto = AccountReqDto.builder().loginId("test").build();

        resDto = AccountResDto.builder()
                .email("test@test.com")
                .loginId("test")
                .username("tester")
                .build();
    }

    @Test
    @WithUserDetails
    public void getResDtoTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(reqDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AccountResDto accountResDto = objectMapper.readValue(contentAsString, AccountResDto.class);
        Assert.assertEquals("test", accountResDto.getLoginId());
    }
}
