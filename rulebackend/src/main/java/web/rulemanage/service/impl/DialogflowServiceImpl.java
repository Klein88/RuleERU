package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import web.rulemanage.service.DialogflowService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class DialogflowServiceImpl implements DialogflowService {

    @Value("522656833570-1cv14p3gfgbgra9ccjkkje5fl61dtca2.apps.googleusercontent.com")
    private String clientId;

    @Value("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")
    private String clientSecret;

    @Value("https://accounts.google.com/o/oauth2/auth")
    private String authUrl;

    @Value("https://accounts.google.com/o/oauth2/token")
    private String tokenUrl;

    @Value("https://localhost:8081")
    private String callbackUrl;

    @Value("https://www.googleapis.com/auth/dialogflow")
    private String scope;

    private RestTemplate restTemplate;

    public DialogflowServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("grant_type", "authorization_code");
        paramMap.add("client_id", clientId);
        paramMap.add("client_secret", clientSecret);
        paramMap.add("redirect_uri", callbackUrl);
//        paramMap.add("code", "authorization_code"); // 这里的 "AUTHORIZATION_CODE" 应该替换为你从 OAuth 流程中获取的授权码。
        paramMap.add("code", "4/0AfJohXkiAhjGKAGnZShMLWTW-5OZgNvRerGNmRdY4hcYjPg5ryVQp_w55Ib8czeiUqkMwg");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramMap, headers);

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(tokenUrl, requestEntity, Map.class);
        Map<String, Object> responseMap = responseEntity.getBody();

        return (String) responseMap.get("access_token");
    }

    @Override
    public String sendRequestToDialogflow(String message) {
        String accessToken = getAccessToken(); // 获取 access token

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        Map<String, Object> textMap = new HashMap<>();
        textMap.put("text", message);

        Map<String, Object> queryInputMap = new HashMap<>();
        queryInputMap.put("text", textMap);
        queryInputMap.put("languageCode", "zh-cn");

        Map<String, Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("timeZone", "America/Los_Angeles");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("queryInput", queryInputMap);
        bodyMap.put("queryParams", queryParamsMap);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        String requestUrl = "https://global-dialogflow.googleapis.com/v3/projects/rule-404306/locations/global/agents/d5af6b2f-bdb4-43eb-8584-fe24fc1cac88/sessions/343:detectIntent";

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(requestUrl, requestEntity, String.class);

        return responseEntity.getBody();
    }
}
