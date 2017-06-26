//package com.study.spring.domain;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.util.Collection;
//
///**
// * Created by SDS on 2017-06-22.
// */
//@Entity
//public class User implements UserDetails {
//
//    @Id
//    private String loginId;
//    private String email;
//
//    // Spring Security User
//    private String username;
//    private String password;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//    private Collection<GrantedAuthority> authorities;
//
//    public String getLoginId() {
//        return loginId;
//    }
//
//    public void setLoginId(String loginId) {
//        this.loginId = loginId;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Collection<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
//}
