package com.study.spring.account.dto;

import com.study.spring.domain.Account;
import com.study.spring.enums.EnableStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AccountCreateDto {

    private String loginId;

    private String username;

    private String password;

    private String email;

    public Account convertToAccount(){
        return Account.builder()
                .email(this.email)
                .loginId(this.loginId)
                .password(this.password)
                .enable(EnableStatus.TRUE)
                .build();
    }
}
