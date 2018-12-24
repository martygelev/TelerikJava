package com.telerikacademy.hms;

public class Nurse extends Staff {
    private int departmentId;

    public Nurse() {
        System.out.println("Default Nurse constructor");
    }

    public Nurse(int departmentId) {
        this.departmentId = departmentId;
        System.out.println("Nurse constructor with only Nurse parameters");
    }

    public Nurse(long id, String firstName, String lastName, String gender, String email, int yearsOfExperience, String description, double salary, int departmentId) {
        //super(id, firstName, lastName, gender, email, yearsOfExperience, description, salary);
        this.departmentId = departmentId;
    }

    public int getNurseId() {
        return departmentId;
    }

    public void setNurseId(int nurseId) {
        this.departmentId = nurseId;
    }
}
