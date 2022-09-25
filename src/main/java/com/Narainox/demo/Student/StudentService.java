package com.Narainox.demo.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }

    public Student insertStudent(Student student)
    {
        return studentRepository.save(student);
    }


    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(long id) {
        return studentRepository.updateStudent();
    }
}
