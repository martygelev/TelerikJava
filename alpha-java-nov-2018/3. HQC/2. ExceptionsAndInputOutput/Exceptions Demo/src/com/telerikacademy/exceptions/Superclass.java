package com.telerikacademy.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Superclass {

    public void test(int parameter){
        if (parameter < 0){
            throw new IllegalArgumentException();
        }

        System.out.println(parameter);
    }
}

class MyChecked extends FileNotFoundException{}
