package com.sta.springrest.controller;

import com.sta.springrest.dto.StudentDto;
import com.sta.springrest.model.Student;
import com.sta.springrest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
     @GetMapping
     public ResponseEntity<List<StudentDto>> getAllStudents(){
         return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.ACCEPTED);
     }

     @PostMapping
    public ResponseEntity<StudentDto> addStudent(RequestEntity<StudentDto> req){
         return new ResponseEntity<>(studentService.addStudent(req.getBody()),HttpStatus.CREATED);
     }

     @PutMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") long studentId,RequestEntity<Student> req){
         req.getBody().setId(studentId);
         return new ResponseEntity<>(studentService.updateStudent(req.getBody()),HttpStatus.ACCEPTED);
     }

     @DeleteMapping("/delete/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable long studentId){
         Student student = studentService.findById(studentId);
         studentService.deleteStudent(studentId);
         return new ResponseEntity(HttpStatus.ACCEPTED);
     }


}
