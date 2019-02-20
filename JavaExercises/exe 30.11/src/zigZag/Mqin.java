package zigZag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mqin {
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

        int currentRow = 1;
        int currentCol = 1;
        int nextCol = 1;
        int downByRow = +1;
        int downByCol = +1;

        long result = getValue(0, 0);

        if (rows <= 1 || cols <= 1) {
            System.out.println(result);
            return;
        }

        while (!isCorner(currentRow, currentCol, rows, cols)) {
            result += getValue(currentRow, currentCol);
            downByRow *= -1;
            nextCol = currentCol + downByCol;

            currentRow = currentRow + downByRow;
            currentCol = currentCol + downByCol;

            if (nextCol >= cols - 1 || nextCol <= 0) {
                downByCol *= -1;
                downByRow *= -1;
            }
        }
        result += getValue(currentRow, currentCol);
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