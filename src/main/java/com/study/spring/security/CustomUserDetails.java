package com.study.spring.security;

import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUserDetails implements UserDetails, Serializable{

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Account account) {
        this.username = account.getId();
        this.password = account.getPassword();

        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : account.getRoles()){
            authorityList.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }

        this.authorities = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomUserDetails)) return false;

        CustomUserDetails that = (CustomUserDetails) o;

        return username != null ? username.equals(that.username) : that.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
