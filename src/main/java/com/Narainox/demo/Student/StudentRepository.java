package com.Narainox.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findById(long id);

    void deleteById(long id);

    Student updateStudent();
}
