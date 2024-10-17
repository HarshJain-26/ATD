package com.harsh.atd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harsh.atd.response.FileResponse;
import com.harsh.atd.service.FileService;

@RestController
@RequestMapping("api/v1/file/")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestPart MultipartFile file) {
        fileService.uploadFile(file);
        return ResponseEntity.ok("File Uploaded");
    }

    @GetMapping
    public ResponseEntity<?> files() {
        FileResponse fileResponse = FileResponse.builder().files(fileService.getFiles())
                .totalFiles(fileService.getFiles().size()).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(fileResponse);
    }

    @GetMapping("{fileName}")
    public ResponseEntity<?> view(@PathVariable String fileName) {
        return ResponseEntity.status(HttpStatus.FOUND).body(fileService.getFile(fileName));
    }

    @GetMapping("{fileName}/download")
    public ResponseEntity<?> download(@PathVariable String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(fileService.getFile(fileName));
    }

    @DeleteMapping("{fileName}")
    public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
        fileService.deleteFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).body("File Deleted");
    }

}
