package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.service.BaiduContentCheckService;
import web.rulemanage.service.HMRCService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hmrc")
public class HMRCController {

    private HMRCService hmrcService;
    @Autowired
    public HMRCController(HMRCService hmrcService) {
        this.hmrcService = hmrcService;
    }

    @PostMapping("/getInitialAccessToken")
    public String getInitialAccessToken() {
        return hmrcService.getInitialAccessToken();
    }

    @PostMapping("/createTestUser")
    public String createTestUser(@RequestParam String accessToken) {
        return hmrcService.createTestUser(accessToken);
    }

    @PostMapping("/getAccessTokenWithCode")
    public String getAccessTokenWithAuthorizationCode(@RequestParam String authorizationCode) {
        return hmrcService.getAccessTokenWithAuthorizationCode(authorizationCode);
    }

    @GetMapping("/getVATInformation")
    public String getVATInformation(@RequestParam String accessToken, @RequestParam String vrn) {
        return hmrcService.getVATInformation(accessToken, vrn);
    }

    @GetMapping("/getVATObligations")
    public String getVATObligations(@RequestParam String accessToken, @RequestParam String vrn, @RequestParam String from, @RequestParam String to) {
        return hmrcService.getVATObligations(accessToken, vrn, from, to);
    }

    @PostMapping("/submitVATReturns")
    public String submitVATReturns(@RequestParam String accessToken, @RequestParam String vrn, @RequestBody String requestBody) {
        return hmrcService.submitVATReturns(accessToken, vrn, requestBody);
    }

    @GetMapping("/getFinancialDetails")
    public String getFinancialDetails(@RequestParam String accessToken, @RequestParam String vrn, @RequestParam String penaltyChargeReference) {
        return hmrcService.getFinancialDetails(accessToken, vrn, penaltyChargeReference);
    }
}
