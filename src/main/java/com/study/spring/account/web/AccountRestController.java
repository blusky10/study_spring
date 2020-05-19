package com.study.spring.account.web;

import com.study.spring.account.dto.AccountCreateDto;
import com.study.spring.account.dto.AccountResDto;
import com.study.spring.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@Slf4j
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

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

    @GetMapping("/pageList")
    public Page<AccountResDto> getPageList(Pageable pageable){
        return accountService.findAll(pageable);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountResDto>> getList(){
        List<AccountResDto> accountResDtoList = accountService.findAll();
        return ResponseEntity.ok(accountResDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountCreateDto accountCreateDto){
        log.debug("ACCOUNT CREATE : " + accountCreateDto.toString());
        accountService.create(accountCreateDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
