package com.polpid.common.user.domain;

import com.polpid.common.user.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Users {
    private String email;
    private String name;
    private UserStatus status;

    @Builder
    public Users(String email, String name, UserStatus status) {
        this.email = email;
        this.name = name;
        this.status = status;
    }
}
