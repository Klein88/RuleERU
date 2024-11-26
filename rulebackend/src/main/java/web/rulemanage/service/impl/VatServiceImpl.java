package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import web.rulemanage.common.VatCheckResponse;
import web.rulemanage.common.VatObligationsRequest;
import web.rulemanage.common.VatObligationsResponse;
import web.rulemanage.service.HmrcAuthService;
import web.rulemanage.service.VatService;

@Service
public class VatServiceImpl implements VatService {

    private final HmrcAuthService hmrcAuthService;

    @Value("https://api.service.hmrc.gov.uk")
    private String baseUrl;

    public VatServiceImpl(HmrcAuthService hmrcAuthService) {
        this.hmrcAuthService = hmrcAuthService;
    }


    @Override
    public VatObligationsResponse retrieveVatObligations(String vatNumber, VatObligationsRequest request) {
        RestTemplate restTemplate = new RestTemplate();  // 创建 RestTemplate 实例
        String url = baseUrl + "/organisations/vat/" + vatNumber + "/obligations";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(hmrcAuthService.getAccessToken()); // 从 HmrcAuthService 获取 access token
        headers.setContentType(MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("from", request.getFromDate())
                .queryParam("to", request.getToDate())
                .queryParam("status", request.getStatus());

        HttpEntity<?> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<VatObligationsResponse> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    VatObligationsResponse.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // 解析错误响应并返回
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                // 如果错误是由于无效凭证导致的，创建并返回错误响应对象
                return new VatObligationsResponse("INVALID_CREDENTIALS", "Invalid Authentication information provided");
            } else {
                // 其他错误类型也可以在这里处理
                return new VatObligationsResponse(e.getStatusCode().toString(), e.getResponseBodyAsString());
            }
        }
    }
}