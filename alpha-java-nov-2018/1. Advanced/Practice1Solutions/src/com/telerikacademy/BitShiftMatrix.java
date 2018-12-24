package com.telerikacademy;

import java.math.BigInteger;
import java.util.Scanner;

public class BitShiftMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read input
        int r = input.nextInt();
        int c = input.nextInt();
        int n = input.nextInt();
        int[] targetCells = new int[n];
        for (int i = 0; i < n; i++) {
            targetCells[i] = input.nextInt();
        }

        // Initialize matrix
        BigInteger[][] matrix = new BigInteger[r][c];
        BigInteger firstRowElement = BigInteger.ONE;
        for (int i = r - 1; i > -1; i--) {
            matrix[i][0] = firstRowElement;
            for (int j = 1; j < c; j++) {
                matrix[i][j] = matrix[i][j - 1].multiply(BigInteger.valueOf(2));
            }
            firstRowElement = firstRowElement.multiply(BigInteger.valueOf(2));
        }

        // Calculate route
        int coef = Math.max(r, c);
        int currentR = r - 1;
        int currentC = 0;
        BigInteger result = BigInteger.ZERO;
        for (int targetCell : targetCells) {
            int targetR = targetCell / coef;
            int targetC = targetCell % coef;

            // Calc horizontal direction
            int horizontalDirection;
            if (currentC <= targetC) {
                horizontalDirection = 1;
            } else {
                horizontalDirection = -1;
            }

            // Calc vertical direction
            int verticalDirection;
            if (currentR <= targetR) {
                verticalDirection = 1;
            } else {
                verticalDirection = -1;
            }

            while (currentC != targetC || currentR != targetR) {
                // If cell is not visited add it to the sum
                if (!matrix[currentR][currentC].equals(BigInteger.ZERO)) {
                    result = result.add(matrix[currentR][currentC]);
                    matrix[currentR][currentC] = BigInteger.ZERO;
                }

                // First go to the target column
                if (currentC != targetC) {
                    currentC += horizontalDirection;
                    continue;
                }

                // Second go to the target row
                if (currentR != targetR) {
                    currentR += verticalDirection;
                }
            }
        }

        // Add last cell
        if (!matrix[currentR][currentC].equals(BigInteger.ZERO)) {
            result = result.add(matrix[currentR][currentC]);
            matrix[currentR][currentC] = BigInteger.ZERO;
        }

        System.out.println(result);
    }
}