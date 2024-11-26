package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.ViesStatusResponse;
import web.rulemanage.service.ViesStatusService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ViesStatusController {

    private final ViesStatusService viesStatusService;

    @Autowired
    public ViesStatusController(ViesStatusService viesStatusService) {
        this.viesStatusService = viesStatusService;
    }

    @GetMapping("/vies/check-status")
    public ResponseEntity<ViesStatusResponse> checkViesStatus() {
        ViesStatusResponse response = viesStatusService.checkStatus();
        return ResponseEntity.ok(response);
    }
}