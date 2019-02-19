package com.telerikacademy.tasks.Recursion;

public class PrintPyramid {

    public static void main(String[] args) {

//        printTriangle(10);
        printPyramid(10, 10);
    }


    private static void printPyramid(int current, int max) {
        if (current == 0) {
            System.out.println(printLineWithLength(max - current));
            return;
        }
        System.out.println(printLineWithLength(max - current));
        printPyramid(current - 1, max);
        System.out.println(printLineWithLength(max - current));
    }

    private static void printTriangle(int i) {
        if (i == 1) {
            printLineRecursive(i);
            return;
        }
//        System.out.println(printLineWithLength(i));
        printLineRecursive(i);

        printTriangle(i - 1);
        printLineRecursive(i);

//        System.out.println(printLineWithLength(i));
    }

    private static String printLineWithLength(int length) {



        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("*");
        }
        return builder.toString();
    }

    private static void printLineRecursive(int length) {
        if (length == 0) {
            System.out.println();
            return;
        }
        System.out.print("*");
        printLineRecursive(length - 1);
    }
}
