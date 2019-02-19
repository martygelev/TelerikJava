package com.telerikacademy.tasks.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {

        int number = 5;

        List<Integer> listOfFibonacciNumbers = new ArrayList<>();
        listOfFibonacciNumbers.add(1);
        listOfFibonacciNumbers.add(1);

        System.out.println(fibonacciWithMemoization(number - 1, listOfFibonacciNumbers));
        for (int num : listOfFibonacciNumbers) {
            System.out.print(num + ", ");
        }
        System.out.println();

        int[] result = new int[number];

        fibOther(number - 1, result);

        for (int a : result) {
            System.out.print(a + ", ");
        }

    }

    private static int fibonacciWithMemoization(int i, List<Integer> result) {
        if (i < result.size()) {
            return result.get(i);
        }
        int number = fibonacciWithMemoization(i - 1, result)
                + fibonacciWithMemoization(i - 2, result);
        result.add(number);
        return result.get(i);
    }

    private static int fibOther(int n, int[] result) {
        if (result[n] == 0) {
            if (n == 1 || n == 0) {
                result[n] = 1;
            } else {
                result[n] = fibOther(n - 1, result) + fibOther(n - 2, result);
            }
        }
        return result[n];
    }
}
