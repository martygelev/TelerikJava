package com.telerikacademy.exceptions.task1;

public class SimpleException {

    public static void main(String args[]) {
        try {
            throw new Throwable("An exception in main");
        } catch (Throwable e) {
            System.out.println(
                    "e.getMessage() = " + e.getMessage());
        } finally {
            System.out.println("In finally clause");
        }
    }
}
