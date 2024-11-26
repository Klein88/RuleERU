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
        map.add("client_id", "522656833570-1cv14p3gfgbgra9ccjkkje5fl61dtca2.apps.googleusercontent.com");
        map.add("client_secret", "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"); // 替换为您的 client_secret
        map.add("grant_type", "authorization_code");
        map.add("code", authorizationCode);
        map.add("redirect_uri", "https://localhost:8081");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        return response.getBody(); // 提取并返回 access token
    }

    @Override
    public String detectIntent(String accessToken, String sessionId, String text, String languageCode, String timeZone) {
        String dialogflowApiUrl = "https://global-dialogflow.googleapis.com/v3/projects/rule-404306/locations/global/agents/d5af6b2f-bdb4-43eb-8584-fe24fc1cac88/sessions/" + sessionId + ":detectIntent";

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
