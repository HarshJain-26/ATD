package com.harsh.atd.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface  FileService {
    public void uploadFile(MultipartFile file);

    public List<String> getFiles();

    public byte[] getFile(String fileName);

    public void deleteFile(String fileName);
}
