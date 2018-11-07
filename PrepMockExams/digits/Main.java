package com.company;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader();
        int n = in.readInt();

        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.readInt();
            }
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (matrix[i][j] == 1 && i >= 2 && i + 2 < n && j + 2 < n && isDigitOne(matrix, i, j)) {
                    result += 1;
                } else if (matrix[i][j] == 2 && i >= 1 && i + 3 < n && j + 2 < n && isDigitTwo(matrix, i, j)) {
                    result += 2;
                } else if (i + 4 < n && j + 2 < n) {
                    if (matrix[i][j] == 3 && isDigitThree(matrix, i, j)) {
                        result += 3;
                    } else if (matrix[i][j] == 4 && isDigitFour(matrix, i, j)) {
                        result += 4;
                    } else if (matrix[i][j] == 5 && isDigitFive(matrix, i, j)) {
                        result += 5;
                    } else if (matrix[i][j] == 6 && isDigitSix(matrix, i, j)) {
                        result += 6;
                    } else if (matrix[i][j] == 7 && isDigitSeven(matrix, i, j)) {
                        result += 7;
                    } else if (matrix[i][j] == 8 && isDigitEight(matrix, i, j)) {
                        result += 8;
                    } else if (matrix[i][j] == 9 && isDigitNine(matrix, i, j)) {
                        result += 9;
                    }
                }
            }

        }
        System.out.println(result);
    }

    private static boolean isDigitTwo(long[][] matrix, int i, int j) {
        return (matrix[i - 1][j + 1] == 2
                && matrix[i + 3][j + 2] == 2
                && matrix[i][j + 2] == 2
                && matrix[i + 1][j + 2] == 2
                && matrix[i + 2][j + 1] == 2
                && matrix[i + 3][j] == 2
                && matrix[i + 3][j + 1] == 2);
    }

    private static boolean isDigitOne(long[][] matrix, int i, int j) {
        return (matrix[i - 1][j + 1] == 1
                && matrix[i + 2][j + 2] == 1
                && matrix[i - 2][j + 2] == 1
                && matrix[i - 1][j + 2] == 1
                && matrix[i][j + 2] == 1
                && matrix[i + 1][j + 2] == 1);

    }

    private static boolean isDigitNine(long[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 9
                && matrix[i + 2][j + 1] == 9
                && matrix[i + 1][j] == 9
                && matrix[i + 4][j + 2] == 9
                && matrix[i][j + 2] == 9
                && matrix[i + 2][j + 2] == 9
                && matrix[i + 4][j] == 9
                && matrix[i + 4][j + 1] == 9

                && matrix[i + 1][j + 2] == 9
                && matrix[i + 3][j + 2] == 9);

    }

    private static boolean isDigitEight(long[][] matrix, int i, int j) {
        return (matrix[i + 4][j + 2] == 8
                && matrix[i + 4][j] == 8
                && matrix[i + 1][j] == 8
                && matrix[i][j + 1] == 8
                && matrix[i + 2][j + 1] == 8
                && matrix[i + 3][j + 2] == 8
                && matrix[i + 3][j] == 8
                && matrix[i + 4][j + 1] == 8
                && matrix[i][j + 2] == 8
                && matrix[i + 1][j + 2] == 8
        );
    }

    private static boolean isDigitSeven(long[][] matrix, int i, int j) {
        return (matrix[i + 4][j + 1] == 7
                && matrix[i + 1][j + 2] == 7
                && matrix[i][j + 2] == 7
                && matrix[i][j + 1] == 7
                && matrix[i + 2][j + 1] == 7
                && matrix[i + 3][j + 1] == 7
        );
    }

    private static boolean isDigitSix(long[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 6
                && matrix[i][j + 2] == 6
                && matrix[i + 4][j + 2] == 6
                && matrix[i + 4][j] == 6
                && matrix[i + 1][j] == 6
                && matrix[i + 2][j] == 6
                && matrix[i + 3][j] == 6
                && matrix[i + 4][j + 1] == 6
                && matrix[i + 2][j + 2] == 6
                && matrix[i + 3][j + 2] == 6
        );
    }

    private static boolean isDigitFive(long[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 5
                && matrix[i + 4][j + 2] == 5
                && matrix[i + 4][j] == 5
                && matrix[i + 1][j] == 5
                && matrix[i + 2][j] == 5
                && matrix[i + 4][j + 1] == 5
                && matrix[i][j + 2] == 5
                && matrix[i + 2][j + 2] == 5
                && matrix[i + 3][j + 2] == 5
        );

    }

    private static boolean isDigitFour(long[][] matrix, int i, int j) {
        return (matrix[i + 1][j] == 4
                && matrix[i + 4][j + 2] == 4
                && matrix[i + 2][j] == 4
                && matrix[i + 2][j + 1] == 4
                && matrix[i][j + 2] == 4
                && matrix[i + 1][j + 2] == 4
                && matrix[i + 2][j + 2] == 4
                && matrix[i + 3][j + 2] == 4
        );

    }

    private static boolean isDigitThree(long[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 3
                && matrix[i + 4][j + 2] == 3
                && matrix[i + 4][j] == 3
                && matrix[i + 4][j + 1] == 3
                && matrix[i][j + 2] == 3
                && matrix[i + 2][j + 1] == 3
                && matrix[i + 1][j + 2] == 3
                && matrix[i + 2][j + 2] == 3
                && matrix[i + 3][j + 2] == 3
        );
    }

    private static boolean isDigitZero(long[][] matrix, int i, int j) {
        return (matrix[i][j + 1] == 0
                && matrix[i + 1][j] == 0
                && matrix[i + 2][j] == 0
                && matrix[i + 3][j] == 0
                && matrix[i + 4][j] == 0
                && matrix[i + 4][j + 1] == 0
                && matrix[i][j + 2] == 0
                && matrix[i + 1][j + 2] == 0
                && matrix[i + 2][j + 2] == 0
                && matrix[i + 3][j + 2] == 0
                && matrix[i + 4][j + 2] == 0);
    }

    static void fakeInput() {
        String test = "7\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "9 9 9 2 2 2 1\n" +
                "1 1 1 1 1 1 1";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
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