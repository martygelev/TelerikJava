package com.telerikacademy.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("test.txt");

        // Write your name and age to the file
        try {
            PrintWriter output = new PrintWriter(file);
            output.println("Nadya");
            output.println("32");
            output.close();
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s\n", e);
        }

        //read from file
        try {
            Scanner input = new Scanner(file);
            String name = input.nextLine();
            int age = input.nextInt();
            System.out.printf("Name: %s\n Age: %d\n", name, age);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s\n", e);
        }

        //you can comment out the writing and change the file's content to see that reading is working

    }
}
