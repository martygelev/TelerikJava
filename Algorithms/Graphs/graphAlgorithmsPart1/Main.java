package graphAlgorithmsPart1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // DFS
    static boolean visited[];
    static List<List<Integer>> graph;
    public static void main(String[] args) {

        graph = readGraph();
        findGraphConnectedComponents();
    }

    public static void findGraphConnectedComponents(){
        visited = new boolean[graph.size()];

        for (int startNode = 0; startNode<graph.size(); startNode++)
        {
            if (!visited[startNode])
            {
                System.out.print("Connected component: ");
                Dfs(startNode);
                System.out.println();

            }
        }
    }

    public static List<List<Integer>> readGraph(){
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
         graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            int[] input = Arrays.stream(line.split("//s+")).mapToInt(Integer::parseInt).toArray();
            for (int i1 : input) {
                graph.get(i).add(i1); // set input values into current graph
            }
        }
        return graph;
    }

    public static void Dfs(int vertex)
    {
        if (!visited[vertex])
        {
            visited[vertex]=true;
            for (int child : graph.get(vertex)) {
                Dfs(child);
            }
            System.out.print(vertex + " ");
        }
    }

}
