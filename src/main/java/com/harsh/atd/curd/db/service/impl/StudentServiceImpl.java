package com.harsh.atd.curd.db.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.atd.curd.db.dto.StudentDTO;
import com.harsh.atd.curd.db.entity.Student;
import com.harsh.atd.curd.db.repository.StudentRepository;
import com.harsh.atd.curd.db.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        // convert dto -> model
        Student student = modelMapper.map(studentDTO, Student.class);

        // save the student in db
        Student saveStudent = studentRepository.save(student);

        // convert model -> dto
        return modelMapper.map(saveStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, Integer studentId) {

        // find the student or else throw error
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No Student Found"));

        Student saveStudent = studentRepository.save(student);

        // convert model -> dto
        return modelMapper.map(saveStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No Student Found"));

        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map((student) -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No Student Found"));

        studentRepository.deleteById(studentId);
    }

}
