package com.Narainox.demo.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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


    public void registerNewStudent(Student student) {
       studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist= studentRepository.existsById(id);
        if (!exist)
        {
            throw new IllegalStateException("Student with Id "+id+" not Exist");
        }
        studentRepository.deleteById(id);
    }


    public Student updateStudent(Student student, Long id) {
        Student student1 = studentRepository.findById(id).get();

        if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
            student1.setName(student.getName());
        }
        if (Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())) {
            student1.setEmail(student.getEmail());
        }
       return studentRepository.save(student1);
    }
}
