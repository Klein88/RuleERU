package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.common.VatCheckResponse;
import web.rulemanage.service.HmrcAuthService;
import web.rulemanage.service.VatCheckService;

@Service
public class VatCheckServiceImpl implements VatCheckService {

    @Autowired
    private HmrcAuthService hmrcAuthService;

    @Override
    public VatCheckResponse checkVatNumber(String vatNumber) {
        try {
            String checkUrl = "https://api.service.hmrc.gov.uk/organisations/vat/check-vat-number/lookup/" + vatNumber;
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(hmrcAuthService.getAccessToken());

            HttpEntity<?> request = new HttpEntity<>(headers);
            ResponseEntity<?> response = restTemplate.exchange(checkUrl, HttpMethod.GET, request, Void.class);

            return new VatCheckResponse(true, "VAT号码存在");
        }catch (HttpClientErrorException.NotFound e) {
            return new VatCheckResponse(false, "VAT号码不存在");
        } catch (HttpClientErrorException e) {
            // 对于其他类型的 HttpClientErrorException 异常，您可以进一步细化处理逻辑
            return new VatCheckResponse(false, "请求失败，错误信息：" + e.getResponseBodyAsString());
        }
    }
}
