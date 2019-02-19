package com.telerikacademy.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Subclass extends Superclass {

    public void test(int parameter) {
        if (parameter < -1) {
            throw new RuntimeException();
        }
    }
}
