package com.study.spring.account.dto;

import lombok.Builder;

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
}
