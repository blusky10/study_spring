package com.study.spring.security.service;

import com.study.spring.account.service.AccountService;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDS on 2017-06-22.
 */
@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Account account = accountService.get(loginId);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : account.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        User user = new User(account.getLoingId(), account.getPassword(), grantedAuthorities);

        return user;
    }
}
