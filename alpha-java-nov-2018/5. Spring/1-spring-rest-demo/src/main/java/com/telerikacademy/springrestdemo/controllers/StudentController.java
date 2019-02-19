package com.telerikacademy.springrestdemo.controllers;

import com.telerikacademy.springrestdemo.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Petar", "Petrov"));
        students.add(new Student(2, "Ivan", "Ivanov"));
    }

    @GetMapping
    public List<Student> getAll() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Student with id %d not found", id)
                ));
    }

    @PostMapping("/new")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
