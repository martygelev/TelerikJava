package com.telerikacademy.tasks.Recursion;

public class RecursivePrintDemo {
    public static void main(String[] args) {
        recursivePrint(6);

        System.out.println("this is the end of main method!");
    }

    private static void recursivePrint(int start) {
        System.out.println("This is the start of the method with argument : " + start);

        if (start == 0) {
            System.out.println("This is the bottom of the recursion! The recursivePrint is called with argument : " + start);
            return;
        }
        System.out.println(start);
        recursivePrint(start - 1);
        System.out.println("This is the end of the method called with argument: " + start);
    }
}
