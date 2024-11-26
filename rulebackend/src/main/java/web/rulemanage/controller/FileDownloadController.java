package web.rulemanage.controller;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/download")
public class FileDownloadController {

//    private final String fileBasePath = "/data/downloads/"; // 您存储文件的目录
//
//    @GetMapping("/{filename:.+}")
//    public ResponseEntity<Resource> downloadSalesData(@PathVariable String filename) {
//        try {
//            Path filePath = Paths.get(fileBasePath + filename);
//            Resource resource = new UrlResource(filePath.toUri());
//
//            if (resource.exists()) {
//                return ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                        .body(resource);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
@GetMapping("/images/{fileName}")
public ResponseEntity<Resource> getImage(@PathVariable String fileName) {

    String imagePath = "/data/upload/" + fileName;


    Resource resource = new FileSystemResource(imagePath);

    if (resource.exists()) {

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    } else {

        return ResponseEntity.notFound().build();
    }
}
}
