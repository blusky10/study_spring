package com.polpid.common.user.domain;

import com.polpid.common.user.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
@Getter
public class Users {
    @Id
    @Column(nullable = false,length = 100)
    private String email;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false)
    private UserStatus userStatus;

    @Builder
    public Users(String email, String name, UserStatus status) {
        this.email = email;
        this.name = name;
        this.userStatus = status;
    }
}
