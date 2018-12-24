package com.telerikacademy;

import java.util.Scanner;

public class BounceRefactored {
    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[][] matrix = createInitialMatrix(n, m);

        long result = matrix[0][0];
        if (!canStartMove(n, m)) {
            System.out.println(result);
            return;
        }

        int currentRow = 0;
        int currentCol = 0;
        int horizontalDirection = 1;
        int verticalDirection = 1;

        // Calculate route
        while (true) {
            verticalDirection = getDirection(n, currentRow, verticalDirection);
            currentRow += verticalDirection;

            horizontalDirection = getDirection(m, currentCol, horizontalDirection);
            currentCol += horizontalDirection;

            result += matrix[currentRow][currentCol];

            if (checkIsCorner(n, m, currentRow, currentCol)) {
                break;
            }
        }

        System.out.println(result);
    }

    private static long[][] createInitialMatrix(int n, int m) {
        long[][] matrix = new long[n][m];
        long firstRowElement = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = firstRowElement;
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j - 1] * 2;
            }
            firstRowElement *= 2;
        }
        return matrix;
    }

    private static boolean canStartMove(int n, int m) {
        return m > 1 && n > 1;
    }

    private static int getDirection(int boundary, int currentPosition, int direction) {
        int nextPosition = currentPosition + direction;
        if (nextPosition < 0 || boundary <= nextPosition) {
            direction *= -1;
        }
        return direction;
    }

    private static boolean checkIsCorner(int rowBoundary, int colBoundary, int currentRow, int currentCol) {
        boolean isCorner = (currentRow == 0 && currentCol == 0) ||
                (currentRow == 0 && currentCol == colBoundary - 1) ||
                (currentRow == rowBoundary - 1 && currentCol == 0) ||
                (currentRow == rowBoundary - 1 && currentCol == colBoundary - 1);
        return isCorner;
    }
}