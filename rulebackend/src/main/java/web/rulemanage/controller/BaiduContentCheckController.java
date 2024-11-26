package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.service.BaiduContentCheckService;

import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class BaiduContentCheckController {

    private BaiduContentCheckService baiduContentCheckService;
    @Autowired
    public BaiduContentCheckController(BaiduContentCheckService baiduContentCheckService) {
        this.baiduContentCheckService = baiduContentCheckService;
    }
    @PostMapping("/baicucheck_content")
    public ResponseEntity<?> checkContent(@RequestBody Map<String, String> payload) {
        String text = payload.get("text");
        boolean isClean = baiduContentCheckService.checkContent(text);
        return ResponseEntity.ok(Map.of("isClean", isClean));
    }
}
