package com.harsh.atd.service;

import java.util.List;

import com.harsh.atd.dto.StudentDTO;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO, Integer studentId);

    StudentDTO getStudent(Integer studentId);

    List<StudentDTO> getStudents();

    void deleteStudent(Integer studentId);
}
