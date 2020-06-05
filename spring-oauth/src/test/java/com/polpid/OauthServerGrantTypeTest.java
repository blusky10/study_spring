package com.polpid;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OauthServerGrantTypeTest {

    private static final String CLIENT_ID = "myclient";
    private static final String CLIENT_SECRET = "secret";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String encodedCredential;

    @Before
    public void setup(){
        String orgClientIdAndSecret = CLIENT_ID + ":" + CLIENT_SECRET;
        Base64.Encoder encoder = Base64.getEncoder();
        encodedCredential = encoder.encodeToString(orgClientIdAndSecret.getBytes());
        System.out.println("encodedCredential : " + encodedCredential);
    }

    @Test
    public void getAccessTokenWithClientCredentials() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + encodedCredential);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        HttpEntity<?> httpEntity = new HttpEntity(body, headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/oauth/token", HttpMethod.POST, httpEntity, String.class);

        Map map = objectMapper.readValue(exchange.getBody(), Map.class);
        Assert.assertEquals(HttpStatus.OK, exchange.getStatusCode());
        Assert.assertNotNull(map.get("access_token"));
        System.out.println(exchange.getBody());
    }

    @Test
    public void getAccessTokenWithPassword() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + encodedCredential);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", "admin");
        body.add("password", "admin1@");

        HttpEntity<?> httpEntity = new HttpEntity(body, headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/oauth/token", HttpMethod.POST, httpEntity, String.class);

        Map map = objectMapper.readValue(exchange.getBody(), Map.class);
        Assert.assertEquals(HttpStatus.OK, exchange.getStatusCode());
        Assert.assertNotNull(map.get("access_token"));
        System.out.println(exchange.getBody());
    }

    @Test
    public void getHelloTest() throws IOException {

        String basicAuth = "myclient:secret";
        Base64.Encoder encoder = Base64.getEncoder();
        String auth = encoder.encode(basicAuth.getBytes()).toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + "bXljbGllbnQ6c2VjcmV0");


        Map<String, String> body = new HashMap<>();
        body.put("grant_type", "client_credentials");

        HttpEntity<?> httpEntity = new HttpEntity(body, headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/common/hello", HttpMethod.POST, httpEntity, String.class);

//        Map map = objectMapper.readValue(exchange.getBody(), Map.class);
//
//        Assert.assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        Assert.assertNotNull(map.get("access_token"));
        System.out.println(exchange.getBody());
    }
}
