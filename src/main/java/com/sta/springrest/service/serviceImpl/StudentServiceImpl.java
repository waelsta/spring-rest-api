package com.sta.springrest.service.serviceImpl;

import com.sta.springrest.dto.StudentDto;
import com.sta.springrest.model.Student;
import com.sta.springrest.repository.StudentRepository;
import com.sta.springrest.service.StudentService;
import com.sta.springrest.utils.StudentErrorResponse;
import com.sta.springrest.utils.customExceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return mapToStudentDto(studentRepository.save(mapToStudent(studentDto)));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        Student student = findById(studentId);
        if(student == null) throw new StudentNotFoundException("student not found !");
        studentRepository.delete(student);
    }

    @Override
    public StudentDto getStudentById(long studentId) {
        return mapToStudentDto(studentRepository.findById(studentId).get());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public Student findById(long studentId) {
        return null;
    }

    //Mappers
    public Student mapToStudent(StudentDto studentDto){
        return Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .password(studentDto.getPassword())
                .id(studentDto.getId())
                .build();
    }

    public StudentDto mapToStudentDto(Student student){
        return StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .password(student.getPassword())
                .id(student.getId())
                .build();
    }
}
