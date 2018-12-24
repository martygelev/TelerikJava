package com.telerikacademy;

import java.util.Scanner;

public class Bounce {
    public static void main(String[] args) {
        // Read input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // Initialize matrix
        long[][] matrix = new long[n][m];
        long firstRowElement = 1;
        for (int i = 0; i < n; i++) {
            matrix[i][0] = firstRowElement;
            for (int j = 1; j < m; j++) {
                matrix[i][j] = matrix[i][j - 1] * 2;
            }
            firstRowElement *= 2;
        }

        int currentR = 0;
        int currentC = 0;
        int horizontalDirection = 1;
        int verticalDirection = 1;

        long result = 1;
        if (m == 1 || n == 1) {
            System.out.println(result);
            return;
        }

        // Calculate route
        while (true) {
            // Calculate potential next position
            int nextR = currentR + verticalDirection;
            int nextC = currentC + horizontalDirection;
            // Change vertical direction
            if (nextR < 0 || n <= nextR) {
                verticalDirection *= -1;
            }
            // Change horizontal direction
            if (nextC < 0 || m <= nextC) {
                horizontalDirection *= -1;
            }
            // Change current position
            currentR += verticalDirection;
            currentC += horizontalDirection;

            result += matrix[currentR][currentC];

            // Check if in corner
            if ((currentR == 0 && currentC == 0) ||
                    (currentR == 0 && currentC == m - 1) ||
                    (currentR == n - 1 && currentC == 0) ||
                    (currentR == n - 1 && currentC == m - 1)) {
                break;
            }
        }

        System.out.println(result);
    }
}