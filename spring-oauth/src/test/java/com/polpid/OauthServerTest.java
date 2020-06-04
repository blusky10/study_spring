package com.polpid;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OauthServerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAccessToken() throws IOException {

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

        Map map = objectMapper.readValue(exchange.getBody(), Map.class);

        Assert.assertNotNull(map.get("access_token"));
        System.out.println(exchange.getBody());
    }
}
