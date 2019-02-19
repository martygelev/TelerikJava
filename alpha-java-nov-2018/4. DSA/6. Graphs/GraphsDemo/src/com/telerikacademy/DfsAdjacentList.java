package com.telerikacademy;

import java.io.ByteArrayInputStream;
import java.util.*;

public class DfsAdjacentList {
    static void testInput() {
        String input = "8\n" +
                "0 1\n" +
                "1 5\n" +
                "2 0\n" +
                "3 7\n" +
                "4 2 7\n" +
                "5 3 6\n" +
                "6 2\n" +
                "7 5\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private static Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static Set<Integer> usedNodes = new HashSet<>();

    public static void main(String[] args) {
        testInput();

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.put(inputLine[0], new HashSet<>());
            for (int j = 1; j < inputLine.length; j++) {
                graph.get(inputLine[0]).add(inputLine[j]);
            }
        }

        dfs(4);
    }

    public static void dfs(int currentNode) {
        useNode(currentNode);
        usedNodes.add(currentNode);

        for (int node : graph.get(currentNode)) {
            if (!usedNodes.contains(node)) {
                dfs(node);
            }
        }
    }

    private static void useNode(int currentNode) {
        System.out.println(currentNode);
    }
}