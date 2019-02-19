import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


 class Kamion {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        String[] input = console.readLine().split(" ");
        int vertices = Integer.parseInt(input[0]);
        int edges = Integer.parseInt(input[1]);
        ArrayList<Edge> edgeList = new ArrayList<>();

        Krus krus = new Krus(vertices);


        for (int i = 0; i < edges; i++) {

            String[] edgesInput = console.readLine().split(" ");
            int vertice = Integer.parseInt(edgesInput[0]) - 1;
            int vertice2 = Integer.parseInt(edgesInput[1]) - 1;
            int weight = Integer.parseInt(edgesInput[2]);

            edgeList.add(new Edge(vertice, vertice2, weight));
        }
        int mstMax = Integer.MAX_VALUE;
        int mstEdges = 0;
        int mstIndexes = 0;

        edgeList.sort(Comparator.reverseOrder());


        while (mstEdges < vertices - 1 && mstIndexes < edges) {

            int a = edgeList.get(mstIndexes).from;
            int b = edgeList.get(mstIndexes).to;
            int w = edgeList.get(mstIndexes).weight;

            if (krus.find(a) != krus.find(b)) {

                krus.unite(a, b);
                if (w < mstMax) {
                    mstMax = w;
                }
                mstEdges++;
            }
            mstIndexes++;
        }
        System.out.println(mstMax);
    }

    static class Edge implements Comparable {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("From:%d To:%d Weight:%d\n", from, to, weight);
        }

        @Override
        public int compareTo(Object o) {
            Edge other = (Edge) o;
            return this.weight - other.weight;
        }
    }

    static class Krus {
        int[] fathers;

        Krus(int vertices) {
            this.fathers = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                fathers[i] = i;
            }
        }

        int find(int x) {
            if (fathers[x] == x) {
                return x;
            }
            return find(fathers[x]);
        }

        void unite(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            fathers[fx] = fy;
        }
    }
}

