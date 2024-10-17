package com.harsh.atd.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.atd.dto.StudentDTO;
import com.harsh.atd.entity.Student;
import com.harsh.atd.repository.StudentRepository;
import com.harsh.atd.service.StudentService;

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
        studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No Student Found"));

        // convert dto -> model
        Student updatedStudent = modelMapper.map(studentDTO, Student.class);

        Student saveStudent = studentRepository.save(updatedStudent);

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
