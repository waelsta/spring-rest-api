package com.sta.springrest.repository;

import com.sta.springrest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    Student save(Student student);

}
