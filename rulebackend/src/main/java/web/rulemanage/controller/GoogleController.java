package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.service.GoogleService;
import web.rulemanage.service.HMRCService;

@RestController
@RequestMapping("/google")
public class GoogleController {
    private GoogleService googleService;
    @Autowired
    public GoogleController(GoogleService googleService) {
        this.googleService = googleService;
    }


    @PostMapping("/getAccessToken")
    public String getAccessToken(@RequestParam String authorizationCode) {
        return googleService.getAccessToken(authorizationCode);
    }

    @PostMapping("/detectIntent")
    public String detectIntent(@RequestParam String accessToken, @RequestParam String sessionId, @RequestParam String text, @RequestParam String languageCode, @RequestParam String timeZone) {
        return googleService.detectIntent(accessToken, sessionId, text, languageCode, timeZone);
    }
}
