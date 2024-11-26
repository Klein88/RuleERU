package web.rulemanage.service.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import web.rulemanage.service.HMRCService;

import java.util.Collections;

@Service
public class HMRCServiceImpl implements HMRCService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getInitialAccessToken() {
        String tokenUrl = "https://test-api.service.hmrc.gov.uk/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("client_id", "hMklCXtoDTJ2yIWdo2cBFHwn0UvV");
        map.add("client_secret", "451f360d-2587-4da3-b47a-7e4dc1688e96");
        map.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request , String.class);

        return response.getBody();
    }

    @Override
    public String createTestUser(String accessToken) {
        String userCreationUrl = "https://test-api.service.hmrc.gov.uk/create-test-user/organisations";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        String jsonRequestBody = "{\"serviceNames\": [\"mtd-vat\"]}";

        HttpEntity<String> request = new HttpEntity<>(jsonRequestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(userCreationUrl, request , String.class);

        return response.getBody();
    }

    @Override
    public String getAccessTokenWithAuthorizationCode(String authorizationCode) {
        String tokenUrl = "https://test-api.service.hmrc.gov.uk/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "hMklCXtoDTJ2yIWdo2cBFHwn0UvV");
        map.add("client_secret", "451f360d-2587-4da3-b47a-7e4dc1688e96");
        map.add("grant_type", "authorization_code");
        map.add("code", authorizationCode);
        map.add("redirect_uri", "http://localhost:8081/oauth/authorize");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        return response.getBody();
    }

    @Override
    public String getVATInformation(String accessToken, String vrn) {
        String vatInfoUrl = "https://test-api.service.hmrc.gov.uk/organisations/vat/" + vrn + "/penalties?from=2016-11-01&to=2017-10-31";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.parseMediaType("application/vnd.hmrc.1.0+json")));
        headers.add("Gov-Test-Scenario", "-");


        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(vatInfoUrl, HttpMethod.GET, request, String.class);

        return response.getBody();
    }
    public String getVATObligations(String accessToken, String vrn, String from, String to) {
        String url = "https://test-api.service.hmrc.gov.uk/organisations/vat/" + vrn + "/obligations?from=" + from + "&to=" + to;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.parseMediaType("application/vnd.hmrc.1.0+json")));
        headers.add("Gov-Test-Scenario", "-");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return response.getBody();
    }
    public String submitVATReturns(String accessToken, String vrn, String requestBody) {
        String url = "https://test-api.service.hmrc.gov.uk/organisations/vat/" + vrn + "/returns";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.parseMediaType("application/vnd.hmrc.1.0+json")));
        headers.add("Gov-Test-Scenario", "-");

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
    public String getFinancialDetails(String accessToken, String vrn, String penaltyChargeReference) {
        String url = "https://test-api.service.hmrc.gov.uk/organisations/vat/" + vrn + "/financial-details/" + penaltyChargeReference;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.parseMediaType("application/vnd.hmrc.1.0+json")));
        headers.add("Gov-Test-Scenario", "-");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return response.getBody();
    }

}
