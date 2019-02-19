package com.telerikacademy.exceptions.task9;

import com.telerikacademy.exceptions.task6.ExBase;
import com.telerikacademy.exceptions.task6.Thrower;

public class Main {
    public static void throwNull() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        Thrower t = new Thrower();

        try {
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " + e);
        } catch (Throwable e) {
            // You could also have just caught
            // Throwable, since it's also a common
            // base class to all three.
        } finally {
            System.out.println("In finally clause");
        }
        try {
            throwNull();
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " + e);
        } catch (Throwable e) {
            // You could also have just caught
            // Throwable, since it's also a common
            // base class to all three.
        } finally {
            System.out.println("In finally clause");
        }

    }

}
