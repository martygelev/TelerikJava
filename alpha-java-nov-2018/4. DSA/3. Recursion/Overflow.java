package com.telerikacademy.tasks.Recursion;

public class Overflow {
    public static void main(String[] args) {
        test(1);
    }

    private static void test(int i) {
        if (i == 0) {
            return;
        }
        System.out.println(++i);
        test(i);

    }
}
