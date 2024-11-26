package web.rulemanage.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.common.VatCheckRequestEU;
import web.rulemanage.service.VatEUService;
import org.springframework.http.*;

@Service
public class VatEUServiceImpl implements VatEUService {
    private static final String VIES_VAT_CHECK_URL = "https://ec.europa.eu/taxation_customs/vies/rest-api//check-vat-number";

    @Override
    public ResponseEntity<String> checkVatNumberEU(VatCheckRequestEU request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<VatCheckRequestEU> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForEntity(VIES_VAT_CHECK_URL, entity, String.class);
    }
}
