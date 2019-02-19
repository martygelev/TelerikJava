package com.telerikacademy;

import java.io.ByteArrayInputStream;
import java.util.*;

public class BfsAdjacentList {
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

    private static Map<Integer, Set<Integer>> graph1 = new HashMap<>();
    private static Set<Integer> usedNodes = new HashSet<>();
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        testInput();

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] inputLine = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph1.put(inputLine[0], new HashSet<>());
            for (int j = 1; j < inputLine.length; j++) {
                graph1.get(inputLine[0]).add(inputLine[j]);
            }
        }

        bfs(0);
    }

    public static void bfs(int currentNode) {
        queue.offer(currentNode);

        while(!queue.isEmpty()){
            currentNode= queue.poll();
            usedNodes.add(currentNode);
            useNode(currentNode);
        }

        for (Integer integer : graph1.get(currentNode)) {
             queue.offer(integer);
            usedNodes.add(integer);
        }
    }

    private static void useNode(int currentNode) {
        System.out.println(currentNode);
    }
}
