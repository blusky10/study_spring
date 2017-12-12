package com.study.spring.auditing.config;


import com.study.spring.auditing.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AuditingConfig {
    @Bean
    SpringSecurityAuditorAware auditorAware() {
        return new SpringSecurityAuditorAware();
    }
}
