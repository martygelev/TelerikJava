package ok;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HorsePath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int topM = 0;
        int leftM = 0;
        int row = 0;
        int col = 0;
        int jump = 1;

        int[][] matrix = new int[size][size];
        matrix[0][0] = jump;
        jump++;

        for (int i = 1; i < size * size; i++) {

            if (checkIfValid(row - 2, col - 1, size)) {
                if (matrix[row - 2][col - 1] == 0) {
                    matrix[row - 2][col - 1] = jump;
                    row += -2;
                    col += -1;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row - 2, col + 1, size)) {
                if (matrix[row - 2][col + 1] == 0) {
                    matrix[row - 2][col + 1] = jump;
                    row += -2;
                    col += +1;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row - 1, col - 2, size)) {
                if (matrix[row - 1][col - 2] == 0) {
                    matrix[row - 1][col - 2] = jump;
                    row += -1;
                    col += -2;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row - 1, col + 2, size)) {
                if (matrix[row - 1][col + 2] == 0) {
                    matrix[row - 1][col + 2] = jump;
                    row += -1;
                    col += +2;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row + 1, col - 2, size)) {
                if (matrix[row + 1][col - 2] == 0) {
                    matrix[row + 1][col - 2] = jump;
                    row += +1;
                    col += -2;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row + 1, col + 2, size)) {
                if (matrix[row + 1][col + 2] == 0) {
                    matrix[row + 1][col + 2] = jump;
                    row += +1;
                    col += +2;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row + 2, col - 1, size)) {
                if (matrix[row + 2][col - 1] == 0) {
                    matrix[row + 2][col - 1] = jump;
                    row += +2;
                    col += -1;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            if (checkIfValid(row + 2, col + 1, size)) {
                if (matrix[row + 2][col + 1] == 0) {
                    matrix[row + 2][col + 1] = jump;
                    row += +2;
                    col += +1;
                    jump++;
                    if (move(row, col, topM, leftM, size)) {
                        topM = row;
                        leftM = col;
                    }

                    continue;
                }
            }
            for (int j = topM; j < size; j++) {
                boolean secBreak = false;
                for (int k = 0; k < size; k++) {
                    if (matrix[j][k] == 0) {
                        matrix[j][k] = jump;
                        row = j;
                        col = k;
                        jump++;
                        topM = row;
                        leftM = col;

                        secBreak = true;
                        break;
                    }
                }
                if (secBreak) break;
            }

        }
        System.out.println(jump);
    }

    public static boolean checkIfValid(int rowIndex, int colIndex, int matrixSize) {
        if (rowIndex >= 0 && rowIndex < matrixSize && colIndex >= 0 && colIndex < matrixSize) {
            return true;
        }
        return false;
    }

    public static boolean move(int row, int col, int rowM, int colM, int matrsizeSize) {
        if (row == rowM && col == colM + 1) {
            return true;
        } else if (row == rowM - 1 && col == 0 && colM == matrsizeSize - 1) {
            return true;
        }
        return false;
    }


}
