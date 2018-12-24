package com.telerikacademy;

import java.util.Scanner;

public class SpitalMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] spiral = new int[n][n];
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        int currentRow = 0;
        int currentCol = 0;
        int currentDirection = 0;

        for (int i = 1; i <= n * n; i++) {
            spiral[currentRow][currentCol] = i;

            int nextRow = currentRow + directions[currentDirection][0];
            int nextCol = currentCol + directions[currentDirection][1];
            if (nextRow < 0 || nextRow >= n
                    || nextCol < 0 || nextCol >= n
                    || spiral[nextRow][nextCol] != 0) {
                currentDirection = (++currentDirection) % 4;
            }

            currentRow += directions[currentDirection][0];
            currentCol += directions[currentDirection][1];
        }

        for (int[] row : spiral) {
            String rowString = "";
            for (int cell : row) {
                rowString += cell + " ";
            }
            System.out.println(rowString.trim());
        }
    }
}