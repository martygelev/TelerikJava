package topologicalSorting;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    public static boolean[] isVisited;
    public static Stack<Integer> stack;
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int value, int destination) {
        adjList[value].addFirst(destination);
    }

    public void sort() {
        isVisited = new boolean[vertices];
        stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!isVisited[i]) {
                topologicalSort(i);
            }
        }
        System.out.println("Topologically sorted: ");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void topologicalSort(int start) {
        isVisited[start] = true;
        for (int i = 0; i < adjList[start].size(); i++) {
            int vetrex = adjList[start].get(i);

            if (!isVisited[vetrex]) {
                topologicalSort(vetrex);
            }
        }
        stack.push(start);
    }

}
