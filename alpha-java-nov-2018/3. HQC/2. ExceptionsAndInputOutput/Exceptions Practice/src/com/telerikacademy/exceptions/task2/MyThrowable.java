package com.telerikacademy.exceptions.task2;

// Following the instructions to the letter:
public class MyThrowable extends Throwable {
    String msg;

    public MyThrowable(String msg) {
        this.msg = msg;
    }

    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}
