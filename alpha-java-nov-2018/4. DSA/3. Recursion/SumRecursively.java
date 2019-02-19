package com.telerikacademy.tasks.Recursion;

public class SumRecursively {
    public static void main(String[] args) {

        int startNumber = 5;

        System.out.println(sumRecursively(startNumber));
    }

    private static int sumRecursively(int number) {
        if (number == 0) {
            return 0;
        }
        int sum = number + sumRecursively(number - 1);
        System.out.println("Sum so far: " + sum);
        return sum;
    }
}
