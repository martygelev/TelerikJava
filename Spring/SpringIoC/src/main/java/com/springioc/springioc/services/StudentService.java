package com.springioc.springioc.services;

import com.springioc.springioc.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    String create(Student student);

    Student getStudentById(int id);

}
