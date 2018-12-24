package com.telerikacademy.hms;

public class Staff extends User {
    private int yearsOfExperience;
    private String description;
    private double salary;
//
    public Staff(){
        System.out.println("Default Staff constructor");
    }
//
    public Staff(long id, String firstName, String lastName, String gender, String email, int yearsOfExperience, String description, double salary) {
        super();
        this.yearsOfExperience = yearsOfExperience;
        this.description = description;
        this.salary = salary;

        System.out.println("Staff constructor with parameters");
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
