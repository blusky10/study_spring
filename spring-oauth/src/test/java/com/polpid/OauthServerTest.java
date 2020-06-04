package com.polpid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OauthServerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAccessToken(){

        String basicAuth = "myclient:secret";
        Base64.Encoder encoder = Base64.getEncoder();
        String auth = encoder.encode(basicAuth.getBytes()).toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + "bXljbGllbnQ6c2VjcmV0");


        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        HttpEntity<?> httpEntity = new HttpEntity(body, headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/oauth/token", HttpMethod.POST, httpEntity, String.class);

        System.out.println(exchange.getBody());
    }
}
