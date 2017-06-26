package com.study.spring.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SDS on 2017-06-21.
 */
@Entity
public class Account {
    @Id
    private String loingId;

    private String username;

    private String password;

    private String email;

    private boolean enabled;

    private List<Role> roles;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}