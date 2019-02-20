package graphsAndGraphAlgo;

import java.util.*;

public class Main {
    public static List<int[]> graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        graph = new ArrayList<>();

        graph.add(0, new int[]{6, 3});      //0
        graph.add(1, new int[]{6, 3, 4, 2});  //1
        graph.add(2, new int[]{4, 1, 5});    //2
        graph.add(3, new int[]{0, 1, 5});    //3
        graph.add(4, new int[]{6, 1, 2});    //4
        graph.add(5, new int[]{2, 3});      //5
        graph.add(6, new int[]{0, 1, 4});    //6
        // add other component
        graph.add(7, new int[]{8, 9});  //7
        graph.add(8, new int[7]);      //8
        graph.add(9, new int[7]);       //9

        visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                System.out.print("new component: ");
                BfsStack(i);
                System.out.println();

            }
        }


    }

    public static void BfsStack(int index) {
        Stack<Integer> queue = new Stack<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            Object currentElement = queue.pop();
            System.out.print(currentElement + " ");

            for (int i : graph.get((int) currentElement)) {

                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void Bfs(int index) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            Object currentElement = queue.poll();
            System.out.print(currentElement + " ");

            for (int i : graph.get((int) currentElement)) {

                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void Dfs(int index) {
        if (!visited[index]) {
            visited[index] = true;

            for (int child : graph.get(index)) {
                Dfs(child);
            }
            System.out.print(index + " ");
        }


    }
}
