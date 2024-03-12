package com.studentmangement.Controller;


import com.studentmangement.Repository.StudentRepository;
import com.studentmangement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //Creating rest apis

    @Autowired
    StudentRepository repo;
    //1st will be  all the student
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student>students = repo.findAll();
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }


    //created student
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

    //Updating
    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id){
       Student student = repo.findById(id).get();
       student.setName("harshad");
       student.setPercentage(89);
       //to save updated details
        repo.save(student);
        return student;
    }

    //Delete record
    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }

}
