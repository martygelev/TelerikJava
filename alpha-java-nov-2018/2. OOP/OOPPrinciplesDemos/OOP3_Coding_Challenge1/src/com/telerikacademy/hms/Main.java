package com.telerikacademy.hms;

public class Main {
    public static void main(String[] args) {
        User user = new Staff(12, "fsf", "fsf", "fsf", "fsf", 10,"",5000);
        System.out.println(user.getFirstName());

//        User user = new User(12, "fsf", "fsf", "fsf", "fsf");
//        System.out.println("");

//        Patient patient = new Patient(12, true);
//        System.out.println("");
//
//        Nurse nurse = new Nurse();
//        System.out.println("");
//
//        nurse = new Nurse(12, "fdf", "fdf", "fdf", "fdf", 11, 5, "fdf", 100, 10);
    }
}
