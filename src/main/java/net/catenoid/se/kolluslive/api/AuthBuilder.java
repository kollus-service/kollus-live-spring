package net.catenoid.se.kolluslive.api;

import net.catenoid.se.kolluslive.kollusenum.Scopes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthBuilder {

    public static HashMap<String,Object> getTokenResponseBody(String token_url, String clientId, String clientSecret, String scopes) throws Exception {
        if (clientId == null || clientId.isEmpty()) {
            throw new Exception("Client ID 값이 없습니다.");
        }
        if (clientSecret == null || clientSecret.isEmpty()) {
            throw new Exception("Client Secret 값이 없습니다.");
        }
        if (scopes == null || scopes.isEmpty()) {
            throw new Exception("Scope 값이 없습니다.");
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("scope", scopes);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<HashMap> response = restTemplate.postForEntity(token_url,
                request, HashMap.class);

        return response.getBody();
    }
    public static String getToken(String token_url, String clientId, String clientSecret, Scopes... scopes) throws Exception {
        String _scopes = Scopes.getScopes(scopes);
        HashMap body = AuthBuilder.getTokenResponseBody(token_url, clientId, clientSecret, _scopes);
        return body.get("access_token").toString();
    }

    public static HttpHeaders getAuthHeader(String token, boolean containBody){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(acceptableMediaTypes);
        if (containBody) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }
        headers.set("X-CRSF-ToKEN", "");
        return headers;
    }

    public static HttpHeaders getAuthHeader(boolean containBody, String token_url, String clientId, String clientSecret, Scopes... scopes) throws Exception {
        String token = AuthBuilder.getToken(token_url, clientId, clientSecret, scopes);
        return AuthBuilder.getAuthHeader(token, containBody);
    }
}
