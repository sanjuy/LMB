package com.gtbsa.LMS.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gtbsa.LMS.helper.FileUploadHelper;


@RestController
@RequestMapping("/api/v2")
public class FileUploadController {
    
    @Autowired
    private FileUploadHelper fileHelper;


    @SuppressWarnings("null")
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("file could not be empty");
        }
        if (!file.getContentType().equals("image/jpeg")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg file");
        }
        // upload file method-=-=-=
        boolean vl = fileHelper.uploadFile(file);
        if (vl) {
            // return ResponseEntity.ok("file upload success");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploadFiles/").path(file.getOriginalFilename()).toUriString());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
}
