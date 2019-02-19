package com.telerikacademy.exceptions.task6;

class Ex1 extends ExBase {
}

class Ex2 extends ExBase {
}

class Ex3 extends ExBase {
}

public class Main {

    public static void main(String args[]) {
        Thrower t = new Thrower();
        try {
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " + e);
        } catch (Exception e) {
            // You could also have just caught
            // Exception, since it's also a common
            // base class to all three.
        }
    }
}
