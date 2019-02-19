package com.telerikacademy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DfsAdjacentMatrix {
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

    private static int[][] graph;
    private static boolean[] usednodes;

    public static void main(String[] args) {
        testInput();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        graph = new int[n][n];
        usednodes = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j < inputLine.length; j++) {
                graph[inputLine[0]][inputLine[j]] = 1;
            }
        }

        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));

        }

        dfs(0);
    }

    private static void dfs(int currentNode) {
        useNode(currentNode);
        usednodes[currentNode] = true;

        for (int i = 0; i < graph[currentNode].length; i++) {
            if (graph[currentNode][i] != 0 && !usednodes[i]) {
                dfs(i);
            }
        }
    }

    private static void useNode(int node) {
        System.out.println(node);
    }
}
