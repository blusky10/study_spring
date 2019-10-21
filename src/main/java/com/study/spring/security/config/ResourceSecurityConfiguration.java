package com.study.spring.security.config;


import com.study.spring.security.handler.LoginFailureHandler;
import com.study.spring.security.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();


        http
            .authorizeRequests()
            .antMatchers("/", "/error/**",  "/h2-console/**", "/favicon.ico/**", "/api/v1/**").permitAll()
            .antMatchers("/private/**").authenticated()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .successHandler(new LoginSuccessHandler())
            .failureHandler(new LoginFailureHandler())
            .and()
            .logout().permitAll()
            .and()
            .sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(false);
    }


//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    //    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.customUserDetailService);
//    }
}

