package web.rulemanage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {
        @PostMapping("/sales-data/{fileName}")
        public String uploadImage(@RequestParam("file") MultipartFile file, @PathVariable String fileName) {
            try {
                String directoryPath = "/data/upload/";
                File directory = new File(directoryPath);

                if (!directory.exists()) {
                    boolean dirCreated = directory.mkdirs();
                    System.out.println("Directory created: " + dirCreated + " - Path: " + directory.getAbsolutePath());
                }

                String savePath = directoryPath + fileName;
                File saveFile = new File(savePath);
                System.out.println("Attempting to save file to: " + saveFile.getAbsolutePath());

                file.transferTo(saveFile);
                return "File uploaded as " + fileName;
            } catch (IOException e) {
                e.printStackTrace();
                return "Upload failed: " + e.getMessage();
            }
        }
    }