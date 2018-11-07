package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int rows = convert(input[0]);
        int cols = convert(input[1]);

        int row = 1;
        int col = 1;
        int nextCol = 1;
        int dRow = +1; //we are starting from [1,1] because of the isCorner check
        int dCol = +1;

        long result = getValue(0, 0);

        if (rows <= 1 || cols <= 1) {
            System.out.println(result);
            return;
        }

        while (!isCorner(row, col, rows, cols)) {
            result += getValue(row, col);
            dRow *= -1;
            nextCol = col + dCol;

            row = row + dRow;
            col = col + dCol;

            if (nextCol >= cols - 1 || nextCol <= 0) {
                dCol *= -1;
                dRow *= -1;
            }
        }
        result += getValue(row, col);
        System.out.println(result);
    }

    private static long getValue(int row, int col) {
        long result = 1 + (3 * (row + col));
        return result;
    }

    private static boolean isCorner(int row, int col, int rows, int cols) {
        return ((row <= 0 || row >= rows - 1) &&
                ((col <= 0 || col >= cols - 1)));
    }
}