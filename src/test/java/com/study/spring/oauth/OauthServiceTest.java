package com.study.spring.oauth;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OauthServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String accessToken;

    @Test
    public void test(){
        accessToken = getOAuth2Token("admin", "admin1!");
        System.out.println(accessToken);
    }

    public String getOAuth2Token(String username, String password) {
        final String CLIENT_ID = "saas_client";
        final String CLIENT_SECRET = "saas_client_secret";
        final String GRANT_TYPE = "password";
        final String SERVER_URL = "http://localhost:8080";
        final String API_OAUTH_TOKEN = "/oauth/token";

        String clientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String base64ClientCredentials = new String(Base64.encodeBase64(clientCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64ClientCredentials);

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("grant_type", GRANT_TYPE);
        parameters.add("username", "sanghyun");
        parameters.add("password", "gsRU6e7krmTuzR5eqhrUng==");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);

        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> response;

        URI uri = URI.create(SERVER_URL + API_OAUTH_TOKEN);
        response = restTemplate.postForEntity(uri, request, Map.class);
        return  (String) response.getBody().get("access_token");
    }

    @Test
    public void getOAuth2TokenTest(){
        Assert.assertNotNull(accessToken);
    }

    @Test
    public void getTestWithAccessToken(){
        final String SERVER_URL = "http://localhost:" + port;
        final String API_URL = "/private?access_token={access_token}";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                SERVER_URL + API_URL,
                String.class,
                accessToken);

        Assert.assertEquals("private", responseEntity.getBody());
    }

    public void postTestWithAccessToken(){
//          ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> paramMap = new HashMap<>();
//
//        String body = null;
//
//        try {
//            body = objectMapper.writeValueAsString(paramMap);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//
//        HttpEntity entity = new HttpEntity(body, headers);
//        TestRestTemplate restTemplate = new TestRestTemplate();
//        ResponseEntity<Boolean> booleanResponseEntity = restTemplate.postForEntity(
//                SERVER_URL + API_URL,
//                entity,
//                boolean.class,
//                access_token);
//
//        Assert.assertTrue(booleanResponseEntity.getBody());
    }
}
