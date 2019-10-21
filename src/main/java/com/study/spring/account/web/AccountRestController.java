package com.study.spring.account.web;

import com.study.spring.account.dto.AccountReqDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.service.AccountService;
import com.study.spring.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/accounts")
@Slf4j
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id){
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountResDto> getResDto(@RequestBody AccountReqDto dto){

        log.debug("INPUT : " + dto.toString() );
        return ResponseEntity.ok(AccountResDto.builder().email("test@test.com")
                .loginId("test")
                .username("tester")
                .build()
        );
    }
}
