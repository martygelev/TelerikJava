package ok;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class OnlineMarket {

    public static void main(String[] args) {
        Solution.start();
    }

    static class Solution {
        static InputReader reader = new InputReader();
        static OutputWriter writer = new OutputWriter();
        static HashSet<String> Products = new HashSet<>();
        static HashMap<String, TreeSet<Product>> orderedByType = new HashMap<>();
        static TreeSet<Product> orderedByPrice = new TreeSet<>();

        public static void start() {
            int length = 0;
            while (true) {
                String[] command = reader.readLine().split(" ");
                switch (command[0]) {
                    case "add":
                        addProduct(command);
                        break;
                    case "filter":
                        length = command.length;
                        if (length == 4) {
                            orderedBytype(command);

                        } else if (length == 5) {
                            if ("from".equals(command[3])) {
                                orderedByMin(command);
                            } else {
                                orderedByMax(command);
                            }
                        } else if (length == 7) {
                            orderedByMinMax(command);
                        }
                        break;
                    case "end":
                        writer.close();
                        return;
                }
            }
        }

        static void addProduct(String[] command) {
            if (Products.contains(command[1])) {
                writer.printLine("Error: Product " + command[1] + " already exists");
            } else {
                Product newProduct = new Product(command[1], command[3], Double.parseDouble(command[2]));
                Products.add(command[1]);
                if (!orderedByType.containsKey(command[3])) {
                    orderedByType.put(command[3], new TreeSet<>());
                }
                orderedByType.get(command[3]).add(newProduct);
                orderedByPrice.add(newProduct);
                writer.printLine("Ok: Product " + command[1] + " added successfully");
            }
        }

        static void orderedBytype(String[] command) {
            if (orderedByType.containsKey(command[3])) {
                writer.printLine("Ok: " + orderedByType.get(command[3]).stream()
                        .limit(10)
                        .map(Product::toString)
                        .collect(Collectors.joining(", ")));
            } else {
                writer.printLine("Error: Type" + command[3] + "does not exists");
            }
        }

        static void orderedByMax(String[] command) {
            writer.printLine("Ok: " + orderedByPrice.stream()
                    .filter(x -> x.price <= Double.parseDouble(command[4]))
                    .map(Product::toString)
                    .limit(10)
                    .collect(Collectors.joining(", ")));
        }

        static void orderedByMin(String[] command) {
            writer.printLine("Ok: " + orderedByPrice.stream()
                    .filter(x -> x.price >= Double.parseDouble(command[4]))
                    .map(Product::toString)
                    .limit(10)
                    .collect(Collectors.joining(", ")));
        }

        static void orderedByMinMax(String[] command) {
            writer.printLine("Ok: " + orderedByPrice.stream()
                    .filter(x -> (x.price > Double.parseDouble(command[4])) && (x.price < Double.parseDouble(command[6])))
                    .map(Product::toString)
                    .limit(10)
                    .collect(Collectors.joining(", ")));
        }
    }

    static class Product implements Comparable {
        String name, type;
        double price;
        DecimalFormat df = new DecimalFormat("#.#####");

        public Product(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s(%s)", name, df.format(price));
        }

        @Override
        public int compareTo(Object o) {
            Product temp = (Product) o;
            double attackCompare = Double.compare(this.price, temp.price);
            if (attackCompare != 0) {
                return (int) attackCompare;
            }
            return -temp.name.compareTo(this.name);
        }
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