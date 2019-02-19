
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

class GreedyDwarf {
    static int[] nextDirection(int[][] field, int row, int col) {
        int[] adjCells = new int[4];

        if (col - 1 >= 0)
            adjCells[0] = field[row][col - 1];
        if (col + 1 < field[0].length)
            adjCells[1] = field[row][col + 1];
        if (row - 1 >= 0)
            adjCells[2] = field[row - 1][col];
        if (row + 1 < field.length)
            adjCells[3] = field[row + 1][col];

        int max = Math.max(Math.max(Math.max(adjCells[0], adjCells[1]), adjCells[2]), adjCells[3]);

        if (max == adjCells[0])
            return new int[]{row, col - 1};
        else if (max == adjCells[1])
            return new int[]{row, col + 1};
        else if (max == adjCells[2])
            return new int[]{row - 1, col};

        return new int[]{row + 1, col};
    }

    static int calculateCoins(int[][] field, int row, int col) {
        if (row >= field.length || col >= field[0].length ||
                row < 0 || col < 0)
            return 0;

        if (field[row][col] == 0)
            return 0;

        if (field[row][col] > 0)
            field[row][col]--;

        int[] nextCellDirection = nextDirection(field, row, col);

        return calculateCoins(field, nextCellDirection[0], nextCellDirection[1]) + 1;
    }

    static int[] findStartCell(int[][] field) {
        for (int row = 0; row < field.length; row++)
            for (int col = 0; col < field[row].length; col++)
                if (field[row][col] == 0)
                    return new int[]{row, col};

        return null;
    }

    static InputReader in = new InputReader();
    static OutputWriter out = new OutputWriter();

    public static void main(String[] args)  {

        String row = in.readLine();

        int[] fieldIndices = Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] field = new int[fieldIndices[0]][fieldIndices[1]];

        for (int i = 0; i < fieldIndices[0]; i++) {
            String inp = in.readLine();
            field[i] = Arrays.stream(inp.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] startCellIndices = findStartCell(field);
        int[] nextCellDirection = nextDirection(field, startCellIndices[0], startCellIndices[1]);
        System.out.println(calculateCoins(field, nextCellDirection[0], nextCellDirection[1]));
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

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}

