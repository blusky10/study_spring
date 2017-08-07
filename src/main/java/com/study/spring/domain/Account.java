package com.study.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    private String loingId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean enable;

    //@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoles = new ArrayList<>();

    public String getLoingId() {
        return loingId;
    }

    public void setLoingId(String loingId) {
        this.loingId = loingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(List<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public void removeAccountRoles(){
        this.accountRoles = new ArrayList<>();
    }
}
