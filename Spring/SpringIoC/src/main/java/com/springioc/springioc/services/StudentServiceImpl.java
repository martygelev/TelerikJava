package com.springioc.springioc.services;

import com.springioc.springioc.models.Student;
import com.springioc.springioc.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAll() {
        return repository.getAll();
    }

    @Override
    public String create(Student student) {
        return repository.create(student);
    }

    @Override
    public Student getStudentById(int id) {
        return repository.getAll().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
