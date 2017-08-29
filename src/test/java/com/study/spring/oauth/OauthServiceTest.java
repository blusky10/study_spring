package com.study.spring.oauth;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * Created by SDS on 2017-08-29.
 */
public class OauthServiceTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private String getOAuth2Token(String username, String password){
        String plainClientCredentials = "myclient:secret";
        String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64ClientCredentials);

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("grant_type", "password");
        parameters.add("username", username);
        parameters.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);

        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> response = null;

        URI uri = URI.create("http://localhost:9000/oauth/token");

        try {
            response = restTemplate.postForEntity(uri, request, Map.class);
        } catch (HttpStatusCodeException e) {

        } catch (RestClientException e) {

        }

        return (String)response.getBody().get("access_token");
    }
}
