
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;


public class Sudoku {

    public static void main(String[] args) {
        InputReader in = new InputReader();

        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = in.readLine();
            String[] lines = line.split("");
            for (int j = 0; j < 9; j++) {
                if (lines[j].equals("-")) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.parseInt(lines[j]);
                }
            }
        }

        solve(matrix);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solve(int[][] sudoku) {
        boolean isThereZero = false;
        int row = 0;
        int col = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    isThereZero = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (isThereZero) {
                break;
            }
        }

        if (!isThereZero) {
            return true;
        }


        for (int i = 1; i <= 9; i++) {
            sudoku[row][col] = i;
            if (isValid(sudoku, row, col)) {
                if (solve(sudoku)) {
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }

        return false;
    }


    public static boolean isValid(int[][] sudoku, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == sudoku[row][col] && i != row) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == sudoku[row][col] && i != col) {
                return false;
            }
        }

        int currentBoxRow = row - row % 3;
        int currentBoxCol = col - col % 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int currRow = currentBoxRow + r;
                int currCol = currentBoxCol + c;
                if (sudoku[currRow][currCol] == sudoku[row][col] && currCol != col && currRow != row) {
                    return false;
                }
            }
        }
        return true;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}