package com.project.Todo.app.controller;

import com.project.Todo.app.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    private FileService fileService;

    public static String UPLOAD_DIRECTORY = "D:\\Work\\Todo-app\\Todo-app\\src\\main\\resources\\static\\images";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        fileService.uploadImage(UPLOAD_DIRECTORY, multipartFile);
        return "Image uploaded successfully";
    }
}
