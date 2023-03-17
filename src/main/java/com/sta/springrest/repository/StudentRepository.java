package com.sta.springrest.repository;

import com.sta.springrest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    Student save(Student student);

}
