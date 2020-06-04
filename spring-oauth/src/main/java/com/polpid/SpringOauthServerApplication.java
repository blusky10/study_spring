package com.polpid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringOauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauthServerApplication.class, args);
    }

}