package com.telerikacademy;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class AboveMainDiagonal {
    static void fakeInput() {
        String test = "4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] matrix = new long[n][n];
        long startValue = 1;

        for (int row = 0; row < n; row++) {
            matrix[row][0] = startValue;
            startValue *= 2;
            for (int col = 1; col < matrix[row].length; col++) {
                matrix[row][col] = matrix[row][col - 1] * 2;
            }
        }

        long sum = 0;
        for (int row = 0; row < n - 1; row++) {
            for (int col = row + 1; col < n; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);
    }
}
