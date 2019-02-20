import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RenewalGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        List<String> paths = new ArrayList<>();
        List<String> builds = new ArrayList<>();
        List<String> destroy = new ArrayList<>();
        for (int i = 0; (i < N); i++) {
            paths.add(in.nextLine());
        }

        for (int i = 0; (i < N); i++) {
            builds.add(in.nextLine());
        }

        for (int i = 0; (i < N); i++) {
            destroy.add(in.nextLine());
        }

        System.out.println(GetCost(paths, builds, destroy));

    }

    static int GetCost(List<String> path, List<String> build, List<String> destroy) {
        int mstCost = 0;
        int N = path.size();
        int massiveCost = 0;
        //  get the cost of each edge + destroy all the existing edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; (i < N); i++) {
            for (int j = (i + 1); (j < N); j++) {
                if ((path.get(i).charAt(j) == '0')) {
                    edges.add(new Edge(i, j, GetValue(build.get(i).charAt(j))));
                } else {
                    int val = GetValue(destroy.get(i).charAt(j));
                    edges.add(new Edge(i, j, (val * -1)));
                    massiveCost = (massiveCost + val);
                }

            }

        }

        edges.sort(Comparator.reverseOrder());
        edges.sort(Comparator.reverseOrder());

        int[] color = new int[N];
        for (int i = 0; (i < N); i++) {
            color[i] = i;
        }

        for (int i = 0; (i < edges.size()); i++) {
            Edge e = edges.get(i);
            //  vertices of the edge are not in the same component
            if ((color[e.a] != color[e.b])) {
                mstCost = (mstCost + e.cost);
                //  recolor the component
                int oldColor = color[e.b];
                for (int j = 0; (j < N); j++) {
                    if ((color[j] == oldColor)) {
                        color[j] = color[e.a];
                    }

                }

            }

        }

        return (massiveCost + mstCost);


    }

    static int GetValue(char c) {
        if (((c >= 'A')
                && (c <= 'Z'))) {
            return (c - 'A');
        }
        return (c - 'a') + 26;
    }


    public static class Edge implements Comparable<Edge> {

        public int a;

        public int b;

        public int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public final int compareTo(Edge e) {
            return (this.cost - e.cost);
        }
    }
}
/*
3
000
000
000
ABD
BAC
DCA
ABD
BAC
DCA
 */