
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Portals {
    private static int cols = 0;
    private static int rows = 0;
    private static int[][] matrix;
    private static int maxSum = 0;
    private static int[] dRows = {-1, 0, +1, 0};
    private static int[] dCols = {0, +1, 0, -1};

    public static void main(String[] args) {
        InputReader in = new InputReader();

        int sr = in.readInt();
        int sc = in.readInt();
        rows = in.readInt();
        cols = in.readInt();
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String input = in.readLine();
                matrix[i][j] = input.equals("#") ? -1 : Integer.parseInt(input);
            }
        }

        int currentCell = sr * cols + sc;
        Set<Integer> visited = new HashSet<>();
        recurse(currentCell, 0, visited);

        System.out.println(maxSum);
    }


    private static void recurse(int currentCell, int tempSum, Set<Integer> visited) {
        boolean hasNext = false;
        int power = power(currentCell);

        if (!visited.contains(currentCell)) {
            int sum = tempSum + power;
            visited.add(currentCell);
            for (int i = 0; i < 4; i++) {
                int next = next(currentCell, power, dRows[i], dCols[i]);
                if (next > -1 && power(next) > -1) {
                    hasNext = true;
                    recurse(next, sum, visited);
                }
            }
            visited.remove(currentCell);
        }

        if (!hasNext) {
            maxSum = Math.max(tempSum, maxSum);
        }
    }

    private static int rowFind(int cell) {
        return cell / cols;
    }

    private static int colFind(int cell) {
        return cell % cols;
    }

    private static int next(int codeCell, int power, int deltaR, int deltaC) {
        int r = rowFind(codeCell);
        int c = colFind(codeCell);

        r += power * deltaR;
        c += power * deltaC;

        int next = r * cols + c;
        return (r < 0 || c < 0 || r >= rows || c >= cols) ? -1 : next;
    }

    private static int power(int codeCell) {
        int r = rowFind(codeCell);
        int c = colFind(codeCell);

        return matrix[r][c];
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
            return c == '\n' || c == '\r' || c == '\t' || c == -1 || c == ' ';
        }
    }
}

