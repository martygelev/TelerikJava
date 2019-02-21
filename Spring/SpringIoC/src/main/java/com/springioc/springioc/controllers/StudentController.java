package com.springioc.springioc.controllers;

import com.springioc.springioc.models.Student;
import com.springioc.springioc.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    @GetMapping()
    public List<Student> students(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudentById(id);
    }

    @PostMapping("/new")
    public String createStudent(@RequestBody Student student){
        return service.create(student);
    }
}
