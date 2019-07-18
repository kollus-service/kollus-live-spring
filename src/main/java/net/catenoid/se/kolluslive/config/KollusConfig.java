package net.catenoid.se.kolluslive.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "kollus")
public class KollusConfig {

    private String clientId;
    private String clientSecret;
    private List<String> scopes;
    private String serviceAccount;


    private String token;
    private String secretKey;
    private String customKey;
    private int expt;


    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public String getServiceAccount() {
        return serviceAccount;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCustomKey() {
        return customKey;
    }

    public void setCustomKey(String customKey) {
        this.customKey = customKey;
    }

    public int getExpt() {
        return expt;
    }

    public void setExpt(int expt) {
        this.expt = expt;
    }
}
