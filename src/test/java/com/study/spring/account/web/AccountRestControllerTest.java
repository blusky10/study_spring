package com.study.spring.account.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.spring.account.dto.AccountReqDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.repository.AccountRepository;
import com.study.spring.account.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRestController accountRestController;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

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
    public void getResDtoTest() throws Exception {

        given(this.accountRestController.getResDto(reqDto)).willReturn(ResponseEntity.ok(resDto));

        ResultActions resultActions = this.mockMvc.perform(
                post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(reqDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
