package com.study.spring.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthServiceConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource datasource;

    private final AuthenticationManager authenticationManager;

    public AuthServiceConfiguration(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 인증서버 보안 설정하는 부분
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // client 정보 설정
        clients.jdbc(datasource);
//        clients
//                .inMemory()
//                .withClient("holmes")
//                .secret("password")
//                .authorizedGrantTypes("password")
//                .scopes("openid");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }
}
