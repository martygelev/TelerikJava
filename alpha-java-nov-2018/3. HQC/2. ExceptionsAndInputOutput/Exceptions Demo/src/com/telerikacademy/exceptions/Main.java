package com.telerikacademy.exceptions;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nInside main ...");

        share();

        System.out.println("\nEnd of main ...");
    }

    private static void share() {
        System.out.println("\nInside share ...");

        HttpConnect.send(0, "hello", "http://www.goodsnips.com");

        // create an exception situation
        // see how the compiler behaves
        // use try-catch
        // re-throw the exception
        // use throws

        // add another exceptional situation
        // add it in throws
        // add multiple catch blocks
        // exceptions can be used polymorphically - no need to throws both can be only the most abstract one
        // multiple catches - if you have specific handling for different situations & start from most concrete one

        // demonstrate unchecked exception - wrong argument - compiler is okay
        // good practice - document it

        // show method overriding


        // add finally in send and share methods and see what is printed in different cases
        // happy case
        // bad case with exception handling
        // bad case with re-throwing it back to main


        System.out.println("\nEnd of share ...");
    }
}
