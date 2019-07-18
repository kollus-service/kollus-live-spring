package net.catenoid.se.kolluslive.api;

import net.catenoid.se.kolluslive.config.KollusConfig;
import net.catenoid.se.kolluslive.kollusenum.Scopes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Component
public class Auth {

    private static final String OAUTH2_TOKEN_URL = "https://live-kr.kollus.com/oauth/token";

    private static Auth _instance = null;

    private String token = null;
    private Date expire = null;


    @Autowired
    private KollusConfig kollusConfig;

    public String getToken() throws Exception{
        if (kollusConfig.getToken() != null){
            return kollusConfig.getToken();
        }
        if (this.token == null || expire == null || expire.getTime() - (new Date()).getTime() < 2 * 24 * 60 * 60 * 1000) {
            refreshToken();
        }
        return this.token;
    }

    private void refreshToken() throws Exception{
        HashMap<String, Object> body = AuthBuilder.getTokenResponseBody(OAUTH2_TOKEN_URL, kollusConfig.getClientId(), kollusConfig.getClientSecret(), String.join(" ", kollusConfig.getScopes()));
        Instant _expire = Instant.now().plusSeconds(Integer.parseInt(body.get("expires_in").toString()));
        this.expire = Date.from(_expire);
        this.token = body.get("access_token").toString();
    }

    public HttpHeaders getAuthHeader(boolean containBody) throws Exception {
        String token = this.getToken();
        return AuthBuilder.getAuthHeader(token, containBody);
    }

}
