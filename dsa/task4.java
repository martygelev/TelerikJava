package ok;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class task4 {
    private static InputReader reader = new InputReader();
    private static OutputWriter writer = new OutputWriter();
    private static HashMap<String, Unit> allUnits = new HashMap<>();
    private static HashMap<String, TreeSet<Unit>> orderedByType = new HashMap<>();
    private static TreeSet<Unit> orderedByAttack = new TreeSet<>();

    public static void main(String[] args) {
            while (true) {
                String[] command = reader.readLine().split(" ");
                switch (command[0]) {
                    case "add":
                        addUnit(command);
                        break;
                    case "remove":
                        removeUnit(command);
                        break;
                    case "find":
                        findUnit(command);
                        break;
                    case "power":
                        unitsPower(command);
                        break;
                    case "end":
                        writer.close();
                        return;
                }
            }
    }

        private static void addUnit(String[] command) {
            if (allUnits.containsKey(command[1])) {
                writer.printLine("FAIL: "+command[1]+" already exists!");
            } else {
                Unit newUnit = new Unit(command[1], command[2], Integer.parseInt(command[3]));

                allUnits.put(command[1], newUnit);

                if (!orderedByType.containsKey(command[2])) {
                    orderedByType.put(command[2], new TreeSet<>());
                }
                orderedByType.get(command[2]).add(newUnit);

                orderedByAttack.add(newUnit);
                writer.printLine("SUCCESS: "+command[1]+" added!");
            }
        }

        private static void removeUnit(String[] command) {
            if (allUnits.containsKey(command[1])) {
                Unit tempUnit = allUnits.get(command[1]);
                allUnits.remove(command[1]);
                orderedByType.get(tempUnit.type).remove(tempUnit);
                orderedByAttack.remove(tempUnit);
                writer.printLine("SUCCESS: "+command[1]+" removed!");
            } else {
                writer.printLine("FAIL: "+command[1]+" could not be found!");
            }
        }

        private static void findUnit(String[] command){
            writer.print("RESULT: ");
            if (orderedByType.containsKey(command[1])){
                writer.print(orderedByType.get(command[1]).stream()
                        .limit(10)
                        .map(Unit::toString)
                        .collect(Collectors.joining(", ")));
            }
            writer.printLine();
        }
        private static void unitsPower(String[] command){
            writer.print("RESULT: ");
            writer.print(orderedByAttack.stream()
                    .limit(Integer.parseInt(command[1]))
                    .map(Unit::toString)
                    .collect(Collectors.joining(", ")));
            writer.printLine();
        }


    public static class Unit implements Comparable {
        String name, type;
        int attack;

        public Unit(String name, String type, int attack) {
            this.name = name;
            this.type = type;
            this.attack = attack;
        }

        @Override
        public String toString() {
            return String.format("%s[%s](%d)", name, type, attack);
        }

        @Override
        public int compareTo(Object o) {
            Unit temp = (Unit) o;
            int attackCompare = Integer.compare(this.attack, temp.attack);
            if (attackCompare != 0) {
                return -attackCompare;
            }
            return this.name.compareTo(temp.name);
        }
    }

   public static class InputReader {
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

    public static class OutputWriter {
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
