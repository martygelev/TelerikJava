package com.telerikacademy.exceptions.task6;

public class Thrower {
    public void f() throws Ex1, Ex2, Ex3 {
        throw new Ex1();
        // You aren't forced to throw all the
        // exceptions in the specification.
    }
}
