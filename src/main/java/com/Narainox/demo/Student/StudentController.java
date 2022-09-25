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

    //Read
    @GetMapping("/getStudent")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }

    //Write
    @PostMapping("/registerNewStudent")
    public String registerNewStudent(@RequestBody Student student)
    {
        studentService.registerNewStudent(student);
        return "Register Student successfully";
    }

    //Delete
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteUser(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
        return "Deleted Successfully";
    }

    //update
    @PutMapping("/updateUser/{id}")
    public Student UpdateStudent(@RequestBody Student student,
                                @PathVariable("id") Long id )
    {
        return studentService.updateStudent(student,id);
    }
}
