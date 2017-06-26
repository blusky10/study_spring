//package com.study.spring.security.config;
//
//import com.study.spring.security.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//
//@Configuration
//@EnableGlobalAuthentication
//public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.customUserDetailService);
//    }
//}
