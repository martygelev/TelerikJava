package com.telerikacademy;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        for (int element : array) {
            System.out.println(element);
        }

        int[][] jaggedArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.printf("%d ", jaggedArray[i][j]);
            }
            System.out.println();
        }

        for (int[] row : jaggedArray) {
            for (int cell : row) {
                System.out.printf("%d ", cell);
            }
            System.out.println();
        }
    }
}
