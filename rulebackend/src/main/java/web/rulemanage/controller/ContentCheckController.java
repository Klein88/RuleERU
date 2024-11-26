package web.rulemanage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.ContentCheckRequest;
import web.rulemanage.common.ContentCheckResponse;
import web.rulemanage.service.ContentCheckService;

@RestController
@RequestMapping("/api")
public class ContentCheckController {

    private final ContentCheckService contentCheckService;

    public ContentCheckController(ContentCheckService contentCheckService) {
        this.contentCheckService = contentCheckService;
    }

    @PostMapping("/check-content")
    public ResponseEntity<ContentCheckResponse> checkContent(@RequestBody ContentCheckRequest request) {
        boolean isAcceptable = contentCheckService.checkContent(request.getContent());
        return ResponseEntity.ok(new ContentCheckResponse(isAcceptable));
    }
}
