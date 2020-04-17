package net.catenoid.se.kolluslive.api;

//import net.catenoid.se.kolluslive.config.KollusConfig;
import net.catenoid.se.kolluslive.config.KollusConfig;
import net.catenoid.se.kolluslive.util.RestTemplateRequestFactory;
import net.catenoid.se.kolluslive.util.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Map;

public abstract class ApiExecutor {

    private final String ROOT_URL = "https://api-live-kr.kollus.com/api/v1/live/service-accounts";
    @Autowired
    protected KollusConfig kollusConfig;
    @Autowired
    protected Auth auth;
    private RestTemplate restTemplate = null;

    protected ApiExecutor() {

        this.restTemplate = new RestTemplateBuilder().rootUri(this.ROOT_URL).errorHandler(
                new RestTemplateResponseErrorHandler()
        ).
                setConnectTimeout(Duration.ofSeconds(30)).build();
//        this.restTemplate.setRequestFactory(new RestTemplateRequestFactory());
    }

    protected Map<String, Object> requestGet(String url, MultiValueMap<String, String> query) throws Exception {
        HttpHeaders authHeader = auth.getAuthHeader(false);
        HttpEntity httpEntity = new HttpEntity(authHeader);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ROOT_URL).path(url);
        if (query != null) {
            builder = builder.queryParams(query);
        }
        ResponseEntity<Map> responseEntity = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, Map.class);
        return responseEntity.getBody();
    }

    protected Map<String, Object> requestPost(String url, MultiValueMap<String, String> query, MultiValueMap<String, String> requestBody) throws Exception {
        HttpHeaders authHeader = auth.getAuthHeader(true);
        HttpEntity httpEntity = new HttpEntity(requestBody, authHeader);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ROOT_URL).path(url);
        if (query != null) {
            builder = builder.queryParams(query);
        }
        ResponseEntity<Map> responseEntity = this.restTemplate.exchange(builder.toUriString(), HttpMethod.POST, httpEntity, Map.class);
        return responseEntity.getBody();
    }

    protected Map<String, Object> requestPut(String url, MultiValueMap<String, String> query, MultiValueMap<String, String> requetBody) throws Exception {
        HttpHeaders authHeader = auth.getAuthHeader(true);
        HttpEntity httpEntity = new HttpEntity(requetBody, authHeader);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if (query != null) {
            builder = builder.queryParams(query);
        }
        ResponseEntity<Map> responseEntity = this.restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, httpEntity, Map.class);
        return responseEntity.getBody();
    }

    protected Map<String, Object> requestDelete(String url) throws Exception {
        HttpHeaders authHeader = auth.getAuthHeader(false);
        HttpEntity httpEntity = new HttpEntity(authHeader);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<Map> responseEntity = this.restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, httpEntity, Map.class);
        return responseEntity.getBody();
    }


}
