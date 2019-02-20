import java.util.*;

public class Reconstruction {
    static class Edge {
        public int From;
        public int To;
        public int Price;

        public Edge(int from, int to, int price) {
            this.From = from;
            this.To = to;
            this.Price = price;
        }

        public int getFrom() {
            return From;
        }

        public int getTo() {
            return To;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        boolean[][] prices = new boolean[n][n];

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String line = in.nextLine();
            for (int j = i + 1; j < n; ++j) {
                prices[i][j] = line.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; ++i) {
            String line = in.nextLine();

            for (int j = i + 1; j < n; ++j) {
                if (prices[i][j]) {
                    continue;
                }

                edges.add(new Edge(i, j, getValue(line.charAt(j))));
            }
        }

        int total = 0;

        for (int i = 0; i < n; ++i) {
            String line = in.nextLine();

            for (int j = i + 1; j < n; ++j) {
                if (prices[i][j]) {
                    int value = getValue(line.charAt(j));
                    total += value;
                    edges.add(new Edge(i, j, -value));
                }
            }
        }

        edges.sort(Comparator.comparingInt(x -> -x.Price));


        Object[] unionarr = edges.stream().filter(x -> x.Price <= -1).toArray();

        for (Edge edge : edges) {
            if (edge.getFrom() >= 0 && edge.getTo() >= 0) {
                if (union(unionarr, edge.getFrom(), edge.getTo())) {
                    total += edge.Price;
                }
            }

        }

        System.out.println(total);
    }

    static int Find(Object[] array, Object x, int index) {
        if (array[index] == x) {
            return index;
        }
        array[index] = Find(array, array[index], index);
        return index;
    }


    public static boolean union(Object[] array, int x, int y) {
        if (x >= 0 && y >= 0) {
            x = Find(array, x, x);
            y = Find(array, y, y);
        } else return false;

        if (x == y) {
            return false;
        }

        array[x] = y;
        return true;
    }

    public static int getValue(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        }

        return c - 'a' + 26;
    }
}
