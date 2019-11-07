package com.study.spring.account.web;

import com.study.spring.account.dto.AccountCreateDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/accounts")
@Slf4j
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResDto> getAccount(@PathVariable Long id){
        return ResponseEntity.ok(accountService.findAccountById(id).convertToAccountResDto());
    }


//    // Post 로 조회를 테스트 해보기 위함 삭제 예정
//    @PostMapping
//    public ResponseEntity<AccountResDto> getAccountList(@RequestBody AccountReqDto dto){
//        log.debug("INPUT : " + dto.toString() );
//        return ResponseEntity.ok(AccountResDto.builder().email("test@test.com")
//                .loginId("test")
//                .username("tester")
//                .build()
//        );
//    }

    @GetMapping
    public Page<AccountResDto> getPageableAccountList(Pageable pageable){
        return accountService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountCreateDto accountCreateDto){

        log.debug("ACCOUNT CREATE : " + accountCreateDto.toString());

        accountService.create(accountCreateDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
