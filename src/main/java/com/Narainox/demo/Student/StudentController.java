package com.Narainox.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudent")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }

    @GetMapping("/getStudentById/{id}")
    public Student insertStudentById(@PathVariable("id") long id)
    {
        return studentService.getStudentById(id);
    }

    @PostMapping("/insertStudent")
    public Student insertStudent(@Validated @RequestBody Student student)
    {
        return studentService.insertStudent(student);
    }

    @DeleteMapping("/deleteAllStudent")
    public void deleteAllStudent()
    {
        studentService.deleteAllStudent();
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable("id") long id)
    {
        studentService.deleteStudentById(id);
        return "Deleted sucessfull";
    }

    @PostMapping("/updateStudent/{id}")
    public Student updateStudent(long id)
    {
        return studentService.updateStudent(id);
    }

}
