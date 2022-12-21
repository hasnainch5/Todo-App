package com.project.Todo.app.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    void uploadImage(String uploadDirectory, MultipartFile multipartFile) throws IOException;
}
