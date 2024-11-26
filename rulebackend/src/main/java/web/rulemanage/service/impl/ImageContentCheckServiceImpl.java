// ImageContentCheckServiceImpl.java

package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import web.rulemanage.service.BaiduAuthService;
import web.rulemanage.service.ImageContentCheckService;

import java.util.Map;

@Service
public class ImageContentCheckServiceImpl implements ImageContentCheckService {

    private final BaiduAuthService baiduAuthService;

    @Autowired
    public ImageContentCheckServiceImpl(BaiduAuthService baiduAuthService) {
        this.baiduAuthService = baiduAuthService;
    }

    @Override
    public boolean checkImageContent(String base64Image, String imgType) {
        String checkUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/img_censor/v2/user_defined"; // 百度图像审核API URL
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("access_token", baiduAuthService.getAccessToken());
        params.add("image", base64Image);
        params.add("imgType", imgType);  // 添加新参数处理

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(checkUrl, request, Map.class);

        // ...处理响应...
        return true; // 根据API的响应结果返回true或false
    }
}
