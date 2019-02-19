import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Actions {
    private static Comparator<int[]> aiCompare = (o1, o2) -> {
        int compareByFirst = o1[0] - o2[0];
        int compareBySecond = o1[1] - o2[1];
        return compareByFirst == 0 ? compareBySecond : compareByFirst;
    };
    private static List<int[]> actions = new ArrayList<>();
    private static Set<Integer> numbers = new HashSet<>();

    public static void main(String[] args) {
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();

        String[] params = in.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            String[] actionStrings = in.readLine().split(" ");
            int[] action = new int[2];
            action[0] = Integer.parseInt(actionStrings[0]);
            action[1] = Integer.parseInt(actionStrings[1]);
            actions.add(action);

//            numbers.add(action[0]);
            numbers.add(action[1]);
        }

        actions.sort(aiCompare);
        findSequence(sequence);

        StringBuilder result = new StringBuilder();
        for (int i : sequence) {
            result.append(i);
            result.append("\n");
        }

        out.printLine(result);
        out.close();
    }


    private static void findSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (numbers.contains(i) && !existsBigger(i)) {
                int iterator = 0;
                while (!actions.isEmpty()) {
                    int[] action = actions.get(iterator);
                    int parent = action[0];
                    int child = action[1];

                    boolean hasParent = hasParent(parent);

                    if (!isParent(child) && child > -1) {
                        int[] childRow = {child, -1};
                        actions.add(childRow);
                    }

                    if (!hasParent) {
                        sequence[i] = parent;
                        deleteAllChildren(parent);
                        break;
                    } else {
                        iterator++;
                    }
                }
            } else if (sequence[i] < 0) {
                int[] action = new int[2];
                action[0] = i;
                action[1] = -1;
                actions.add(action);
                sequence[i] = i;
            }
        }
    }

    private static boolean existsBigger(int number) {
        for (Integer integer : numbers) {
            if (integer == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isParent(int child) {
        for (int[] action : actions) {
            if (child == action[0]) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasParent(int parent) {
        for (int[] action : actions) {
            if (parent == action[1]) {
                return true;
            }
        }
        return false;
    }

    private static void deleteAllChildren(int parent) {
        actions = actions.stream()
                .filter(x -> parent != x[0])
                .collect(Collectors.toList());
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
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
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
