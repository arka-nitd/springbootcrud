package com.helix.practice.demo2.controller;

import com.helix.practice.demo2.models.Student;
import com.helix.practice.demo2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> findAllStudents() { return studentService.getAllStudents(); }

    @GetMapping(value = "/{id}")
    public Student findStudentById(@PathVariable Long id){ return studentService.getStudentById(id); }

    @PostMapping()
    public Student insertStudent(@RequestBody Student student){ return studentService.insertStudent(student); }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(value="/{id}")
    public Student updateUserById(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

}
