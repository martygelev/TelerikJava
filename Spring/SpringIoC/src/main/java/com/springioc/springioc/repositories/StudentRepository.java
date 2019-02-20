package com.springioc.springioc.repositories;

import com.springioc.springioc.models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();

    String create(Student student);

    String delete(Student student);

    String sort();

    void removeAll();
}
