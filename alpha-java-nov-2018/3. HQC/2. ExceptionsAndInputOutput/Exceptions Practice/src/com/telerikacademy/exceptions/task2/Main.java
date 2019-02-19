package com.telerikacademy.exceptions.task2;

public class Main {

    public static void main(String[] args) {
        try {
            throw new MyThrowable("MyException message");
        } catch (MyThrowable e) {
            e.printMsg();
        }
        try {
            throw new MyThrowable2("MyException2 message");
        } catch (MyThrowable2 e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}