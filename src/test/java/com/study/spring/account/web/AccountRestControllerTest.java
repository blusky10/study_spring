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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    private List<AccountResDto> accountResDtoList = new ArrayList<>();
    private Page<AccountResDto> accountResDtoPage;

    @Before
    public void setup(){

        reqDto = AccountReqDto.builder().loginId("test").build();

        resDto = AccountResDto.builder()
                .email("test@test.com")
                .loginId("test")
                .username("tester")
                .build();

        accountResDtoList.add(resDto);
        accountResDtoPage = new PageImpl<AccountResDto>(accountResDtoList);
    }

    @Test
    @WithUserDetails
    public void createTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(objectMapper.writeValueAsString(reqDto)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        AccountResDto accountResDto = objectMapper.readValue(contentAsString, AccountResDto.class);
        Assert.assertEquals("test", accountResDto.getLoginId());
    }

    @Test
    @WithUserDetails
    public void getPageableListTest() throws Exception {
        given(accountService.findAll(any())).willReturn(accountResDtoPage);
        MvcResult mvcResult = this.mockMvc.perform(
                get("/api/v1/accounts/pageList")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        HashMap resultMap = objectMapper.readValue(contentAsString, HashMap.class);
        Assert.assertEquals(1, resultMap.get("totalElements"));
    }

    @Test
    @WithUserDetails
    public void getListTest() throws Exception {
        given(accountService.findAll()).willReturn(accountResDtoList);
        MvcResult mvcResult = this.mockMvc.perform(
                get("/api/v1/accounts/list")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<HashMap> accountResDto = objectMapper.readValue(contentAsString, List.class);
        Assert.assertEquals(1, accountResDto.size());
        Assert.assertEquals("test", accountResDto.get(0).get("loginId"));


    }
}
