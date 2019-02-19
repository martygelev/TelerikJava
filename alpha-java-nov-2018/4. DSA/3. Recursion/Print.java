package com.telerikacademy.tasks;

public class Print {
    public static void main(String[] args) {
        int startNumber = 6;

//        printNumbersRecursively(startNumber);
//        System.out.println(sumRecursively(startNumber));
//        printTriangle(startNumber);
//        printTriangle(10);
        printPyramid(1, 10);
    }

    private static void printPyramid(int start, int max) {

        if (start == max) {
            printLine(max);
            return;
        }
        printLine(start);
        printPyramid(start + 1, max);
        printLine(start);
    }

    private static void printTriangle(int start) {

        if (start == 1) {
            printLine(start);
            return;
        }
        printLine(start);
        printTriangle(start - 1);
        printLine(start);

    }



    private static void printLine(int start) {
        if (start == 0) {
            System.out.println();
            return;
        }
        System.out.print("*");
        printLine(start - 1);
    }

    private static void printNumbersRecursively(int startNumber) {
        System.out.println("This is the start of recursive call with argument :"  + startNumber);
        if (startNumber == 0) {
            System.out.println(startNumber);
            System.out.println("This is the bottom of the recursion!");
            return;
        }

        System.out.println(startNumber);
        printNumbersRecursively(startNumber - 1);
        System.out.println(startNumber);
        System.out.println("This is the end of recursive call with argument :" + startNumber);
    }
}
