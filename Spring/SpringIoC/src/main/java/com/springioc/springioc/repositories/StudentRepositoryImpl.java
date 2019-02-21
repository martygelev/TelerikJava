package com.springioc.springioc.repositories;

import com.springioc.springioc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Pesho"),
                    new Student(2, "Toshko")
            )
    );


    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    @Override
    public String create(Student student) {
        students.add(student);

        return "add -> " + student.getName();
    }

    @Override
    public String delete(Student student) {
        students.remove(student.getId());

        return "remove -> "+ student.getName();
    }

    @Override
    public String sort() {

        StringBuilder sb = new StringBuilder();

        students.sort(Comparator.comparing(Student::getName));

        students.forEach(sb::append);

        return sb.toString();
    }


    @Override
    public void removeAll() {
        students.clear();
    }
}
