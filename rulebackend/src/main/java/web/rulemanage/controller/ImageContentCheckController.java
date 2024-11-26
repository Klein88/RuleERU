// ImageContentCheckController.java

package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.service.ImageContentCheckService;

import java.util.Map;

@RestController
@RequestMapping("/image-content-check")
public class ImageContentCheckController {

    private final ImageContentCheckService imageContentCheckService;

    @Autowired
    public ImageContentCheckController(ImageContentCheckService imageContentCheckService) {
        this.imageContentCheckService = imageContentCheckService;
    }

    @PostMapping("/image")
    public ResponseEntity<?> checkImageContent(@RequestParam("image") String base64Image,
                                               @RequestParam("imgType") String imgType) {
        boolean isClean = imageContentCheckService.checkImageContent(base64Image, imgType);
        return ResponseEntity.ok(Map.of("isClean", isClean));
    }
}
