package com.study.spring.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountReqDto {

    private String loginId;

    @Builder
    public AccountReqDto(String loginId) {
        this.loginId = loginId;
    }
}
