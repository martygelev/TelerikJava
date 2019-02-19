package com.telerikacademy.springrestdemo.models;

import javax.validation.constraints.Size;

public class Student {
    private int id;

    @Size(min = 2, max = 20, message = "Incorect size for firstName.")
    private String firstName;

    @Size(min = 5, max = 15, message = "Incorect size for lastName.")
    private String lastName;


    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
