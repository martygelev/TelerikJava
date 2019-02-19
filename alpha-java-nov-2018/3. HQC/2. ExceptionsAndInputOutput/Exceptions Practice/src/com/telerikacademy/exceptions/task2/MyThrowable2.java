package com.telerikacademy.exceptions.task2;

// Or you can take a more clever approach, and
// note that string storage and printing is
// built into Throwable:
public class MyThrowable2 extends Throwable {
    public MyThrowable2(String s) {
        super(s);
    }
}
