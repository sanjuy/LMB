package com.gtbsa.LMS.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    // public final String uploadDir = "src/main/resources/static/uploadFiles";
    public final String uploadDir = new ClassPathResource("/static/uploadFiles").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException
    {
        
    }

    public boolean uploadFile(MultipartFile file) {
        boolean f = false;

        try{
            Files.copy(file.getInputStream(), Paths.get(uploadDir+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (IOException e) {
        }

        return f;
    }
}
