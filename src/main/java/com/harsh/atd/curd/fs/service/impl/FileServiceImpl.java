package com.harsh.atd.curd.fs.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.harsh.atd.curd.fs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String path;

    @Override
    public void uploadFile(MultipartFile file) {
        File f = new File(path);

        if (!f.exists()) {
            f.mkdir();
        }

        String fileName = file.getOriginalFilename();
        FileSystemResource fsr = new FileSystemResource(path + fileName);

        try (OutputStream outputStream = fsr.getOutputStream()) {
            outputStream.write(file.getBytes());
            outputStream.close();
        } catch (IOException e) {
            log.info(e.getMessage());
        }

    }

    @Override
    public List<String> getFiles() {
        File filePath = new File(path);

        if (!filePath.exists()) {
            throw new RuntimeException("Dir. not exists");
        }

        return Stream.of(filePath.listFiles()).map((file) -> file.getName()).toList();
    }

    @Override
    public byte[] getFile(String fileName) {
        File file = new File(path + fileName);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        try (FileInputStream fs = new FileInputStream(file)) {
            byte[] allBytes = fs.readAllBytes();
            fs.close();

            return allBytes;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void deleteFile(String fileName) {
        File file = new File(path + fileName);

        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        file.delete();
    }

}
