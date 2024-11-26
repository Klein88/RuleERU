// BaiduContentCheckServiceImpl.java

package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.service.BaiduAuthService;
import web.rulemanage.service.BaiduContentCheckService;

import java.util.Map;

@Service
public class BaiduContentCheckServiceImpl implements BaiduContentCheckService {

    private final BaiduAuthService baiduAuthService;

    @Autowired
    public BaiduContentCheckServiceImpl(BaiduAuthService baiduAuthService) {
        this.baiduAuthService = baiduAuthService;
    }

    @Override
    public boolean checkContent(String text) {
        String checkUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/text_censor/v2/user_defined";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("access_token", baiduAuthService.getAccessToken());
        params.add("text", text);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(checkUrl, request, Map.class);

        // 此处简化处理，实际应根据百度内容审核API的响应结构进行适当处理
        if (response.getStatusCode() == HttpStatus.OK) {
            Map responseBody = response.getBody();
            if (responseBody != null) {
                // 例如，根据百度API的响应结构取得审核结果
                // 以下代码假设API返回的结构包含"conclusionType"字段，您需要根据实际API调整
                int conclusionType = (int) responseBody.get("conclusionType");
                // 假设当conclusionType为1时表示内容正常
                return conclusionType == 1;
            }
        }
        return false;
    }
}
