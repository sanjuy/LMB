// package com.gtbsa.LMS.helper;

// import org.springframework.stereotype.Component;

// @Component
// public class FileUploadHelper {
    
//     // public final String uploadDir = "src/main/resources/static/uploadFiles";
//     public final String uploadDir = new ClassPathResource("/static/uploadFiles").getFile().getAbsolutePath();

//     public FileUploadHelper() throws IOException
//     {
        
//     }

//     public boolean uploadFile(MultipartFile file) {
//         boolean f = false;

//         try{
//             Files.copy(file.getInputStream(), Paths.get(uploadDir+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//             f = true;
//         } catch (IOException e) {
//         }

//         return f;
//     }
// }
