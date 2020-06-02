package com.polpid;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class SpringPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesApplication.class, args);
    }

    private final Environment environment;
    private final MyProperties myProperties;

    public SpringPropertiesApplication(Environment environment, MyProperties myProperties) {
        this.environment = environment;
        this.myProperties = myProperties;
    }

    @Bean
    CommandLineRunner myRunner(){
        return args -> {
            log.info("application Name : " + myProperties.getApplicationName());
            log.info("server port : " + environment.getProperty("server.port"));
            System.out.println();
        };
    }
}