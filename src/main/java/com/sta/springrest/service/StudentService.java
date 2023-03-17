package com.sta.springrest.service;

import com.sta.springrest.dto.StudentDto;
import com.sta.springrest.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentDto);

    Student updateStudent(Student student);

    void deleteStudent(long studentId);

    StudentDto getStudentById(long studentId);

    List<StudentDto> getAllStudents();

    Student findById(long studentId);
}
