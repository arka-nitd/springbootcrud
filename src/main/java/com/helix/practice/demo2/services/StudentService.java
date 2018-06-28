package com.helix.practice.demo2.services;


import com.helix.practice.demo2.models.Student;
import com.helix.practice.demo2.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    public List<Student> getAllStudents() {
        return this.studentJpaRepository.findAll();
    }
    public Student insertStudent(Student student){
        return studentJpaRepository.save(student);
    }

    public Student getStudentById(Long id) {
        Optional<Student> student  = studentJpaRepository.findById(id);
        if(student.isPresent())
            return student.get();
        else
            throw new NoSuchElementException("Student not found");
    }

    public void deleteStudentById(Long id) {
        studentJpaRepository.deleteById(id);
    }

    public Student updateStudentById(Long id, Student student) {
        Student u = studentJpaRepository.findById(id).orElseThrow(
                ()-> new EmptyResultDataAccessException(String.format("No Such Student Present"),1));
        u.setName(student.getName());
        u.setCourse(student.getCourse());
        u.setRoll(student.getRoll());
        studentJpaRepository.save(u);
        return u;
    }


}

