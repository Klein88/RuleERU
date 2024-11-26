package web.rulemanage.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpMethod;
import web.rulemanage.service.GoogleService;

import java.util.Collections;

@Service
public class GoogleServiceImpl implements GoogleService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getAccessToken(String authorizationCode) {
        String tokenUrl = "https://accounts.google.com/o/oauth2/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("client_id", "aaa");
        map.add("client_secret", "bbb"); // 替换为您的 client_secret
        map.add("grant_type", "authorization_code");
        map.add("code", authorizationCode);
        map.add("redirect_uri", "https://localhost:8081");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        return response.getBody(); // 提取并返回 access token
    }

    @Override
    public String detectIntent(String accessToken, String sessionId, String text, String languageCode, String timeZone) {
        String dialogflowApiUrl = "ccc" + sessionId + ":detectIntent";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String jsonRequestBody = "{"
                + "\"queryInput\": {"
                + "\"text\": {"
                + "\"text\": \"" + text + "\""
                + "},"
                + "\"languageCode\": \"" + languageCode + "\""
                + "},"
                + "\"queryParams\": {"
                + "\"timeZone\": \"" + timeZone + "\""
                + "}"
                + "}";

        HttpEntity<String> request = new HttpEntity<>(jsonRequestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(dialogflowApiUrl, HttpMethod.POST, request, String.class);

        return response.getBody();
    }
}
