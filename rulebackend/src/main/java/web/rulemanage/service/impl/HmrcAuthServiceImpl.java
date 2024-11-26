package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.service.HmrcAuthService;

import java.util.Map;

@Service
public class HmrcAuthServiceImpl implements HmrcAuthService {

    @Value("${hmrc.client.id}")
    private String clientId;

    @Value("${hmrc.client.secret}")
    private String clientSecret;

    private String accessToken;

    @Override
    public String getAccessToken() {
        if (accessToken == null) {
            refreshToken();
        }
        return accessToken;
    }

    private void refreshToken() {
        String authUrl = "https://test-api.service.hmrc.gov.uk/oauth/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_secret", clientSecret);
        params.add("client_id", clientId);
        params.add("grant_type", "client_credentials");
        params.add("scope", "read:vat");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(authUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            accessToken = (String) response.getBody().get("access_token");
        } else {
            throw new IllegalStateException("Failed to retrieve access token from HMRC");
        }
    }
}
