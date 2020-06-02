package com.polpid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringPropertiesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringPropertiesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesApplication.class, args);
    }

    @Autowired
    Environment enviroment;

    @Autowired
    private MyProperties myProperties;

    @Bean
    CommandLineRunner myRunner(){
        return args -> {
            LOGGER.info("application Name : " + myProperties.getApplicationName());
            LOGGER.info("server port : " + enviroment.getProperty("server.port"));
            System.out.println();
        };
    }
}