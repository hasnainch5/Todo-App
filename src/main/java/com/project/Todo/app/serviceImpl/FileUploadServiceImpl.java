package com.project.Todo.app.serviceImpl;

import com.project.Todo.app.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileService {
    @Override
    public void uploadImage(String uploadDirectory, MultipartFile multipartFile) throws IOException {

        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        File checkForFile = new File(uploadDirectory + File.separator + fileName);
        if (!checkForFile.exists()) {
            saveFile(uploadDirectory + File.separator + fileName, multipartFile);
        } else {
            int count = 0;
            while (true) {
                String onlyName = fileName.substring(0, fileName.lastIndexOf("."));
                String extension = fileName.substring(fileName.lastIndexOf("."));
                String fileNameToSave = onlyName + "-" + count + extension;
                String completeFilePath = uploadDirectory + File.separator + fileNameToSave;
                File file = new File(completeFilePath);
                if (!file.exists()) {
                    saveFile(completeFilePath, multipartFile);
                    break;
                }
                count += 1;
            }
        }
    }

    private static void saveFile(String uploadFilePath, MultipartFile multipartFile) throws IOException {
        Files.copy(multipartFile.getInputStream(), Paths.get(uploadFilePath));
    }
}
