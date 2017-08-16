package com.study.spring.security.service;

import com.study.spring.account.service.AccountService;
import com.study.spring.domain.Account;
import com.study.spring.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);


    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Account account = accountService.get(loginId);

        logger.debug("username : " + account.getUsername() );

        String roles = account.getAccountRoles().stream().map(
                accountRole -> accountRole.getRole().getName()
        ).collect(Collectors.joining(","));

        logger.debug("Roles : " + roles );

        User user = new User(account.getLoingId(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(roles));

        return user;
    }
}
