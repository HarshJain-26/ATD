package com.harsh.atd.curd.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.atd.curd.db.dto.StudentDTO;
import com.harsh.atd.curd.db.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("student")
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer studentId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudent(studentId));
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudents());
    }

    @PutMapping("student/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer studentId,
            @Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.updateStudent(studentDTO, studentId));
    }

    @DeleteMapping("student/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student Deleted");
    }
}