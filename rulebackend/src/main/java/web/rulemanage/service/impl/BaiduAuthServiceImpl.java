// BaiduAuthServiceImpl.java

package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.service.BaiduAuthService;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class BaiduAuthServiceImpl implements BaiduAuthService {

    @Value("${baidu.api.key}")
    private String clientId;

    @Value("${baidu.api.secret}")
    private String clientSecret;

    private String accessToken;

    @PostConstruct
    public void init() {
        refreshAccessToken();
    }

    @Override
    public void refreshAccessToken() {
        String authUrl = "https://aip.baidubce.com/oauth/2.0/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(authUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map responseBody = response.getBody();
            if (responseBody != null) {
                accessToken = (String) responseBody.get("access_token");
            }
        } else {
            throw new IllegalStateException("Failed to retrieve access token from Baidu API");
        }
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
}
