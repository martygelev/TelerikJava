package com.telerikacademy.exceptions.task3;

import com.telerikacademy.exceptions.task2.MyThrowable;

class Thrower2 {
    public void f() {
        // Compiler gives an error: "unreported
        // exception MyThrowable; must be caught or
        // declared to be thrown"
        //! throw new MyThrowable("Inside f()");
    }

    public void g() throws MyThrowable {
        throw new MyThrowable("Inside f()");
    }
}

public class Main {

    public static void main(String[] args) {
        Thrower2 t = new Thrower2();
        try {
            t.g();
        } catch (MyThrowable e) {
            e.printMsg();
        }
    }
}
