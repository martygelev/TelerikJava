import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

 class Deistviq {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int vert = console.nextInt();
        int edges = console.nextInt();

        Graph graph = new Graph(vert);

        for (int i = 0; i < edges; i++) {

            graph.addEdge(console.nextInt(), console.nextInt());
        }
        graph.topologicalSort();
    }



    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void topologicalSortUtil(int v, boolean visited[],
                                 Stack stack) {
            visited[v] = true;
            Integer i;

            // vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }

            stack.push(v);
        }

        void topologicalSort() {
            Stack stack = new Stack();

            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            while (stack.empty() == false)
                System.out.println(stack.pop());
        }
    }
}