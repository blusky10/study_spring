package com.study.spring.account.dto;

import com.study.spring.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountResDto {

    private String loginId;
    private String username;
    private String email;

    @Builder
    public AccountResDto(String loginId, String username, String email) {
        this.loginId = loginId;
        this.username = username;
        this.email = email;
    }

    public AccountResDto(Account account) {
        this.loginId = account.getLoginId();
        this.username = account.getUsername();
        this.email = account.getEmail();
    }
}
