package com.polpid.common.user.service;

import com.polpid.common.user.domain.Users;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserExternalService {

    private RestTemplate restTemplate;

    public UserExternalService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Users findUserById(String id){
        return restTemplate.getForObject("/api/v1/users/" + id, Users.class);
    }
}
