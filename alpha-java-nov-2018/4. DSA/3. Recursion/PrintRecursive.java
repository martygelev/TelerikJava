package com.telerikacademy.tasks.Recursion;

public class PrintRecursive {
    public static void main(String[] args) {

        int startNumber = 5;

        recursivePrintCall(startNumber);
    }
    private static void recursivePrintCall(int i) {
        System.out.println("This is the start of recursivePrintCall: " + i);
        if (i == 0) {
            System.out.println("This is the bottom of the recursion!");
            return;
        }
        recursivePrintCall(i - 1);
        System.out.println("This is recursivePrintCall: " + i + " end");
    }
}
