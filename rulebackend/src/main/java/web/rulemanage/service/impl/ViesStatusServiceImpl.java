package web.rulemanage.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.common.ViesStatusResponse;
import web.rulemanage.service.ViesStatusService;
import org.springframework.http.*;

// ViesStatusServiceImpl.java
@Service
public class ViesStatusServiceImpl implements ViesStatusService {

    private static final String VIES_STATUS_URL = "https://ec.europa.eu/taxation_customs/vies/rest-api//check-status";

    @Override
    public ViesStatusResponse checkStatus() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<ViesStatusResponse> response = restTemplate.exchange(
                VIES_STATUS_URL, HttpMethod.GET, entity, ViesStatusResponse.class);

        return response.getBody();
    }
}
