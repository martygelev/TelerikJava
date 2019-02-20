import java.util.*;

public class ConferenceDevelopers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] firstLine = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = firstLine[0];
        int pairs = firstLine[1];

        boolean[] visited = new boolean[count];
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();

        for (int i = 0; i < pairs; i++) {
            int[] pair = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!graph.containsKey(pair[0])) {
                graph.put(pair[0], new HashSet<>());
            }

            if (!graph.containsKey(pair[1])) {
                graph.put(pair[1], new HashSet<>());

            }

            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }


        List<Long> componentsNodesCount = new ArrayList<>();
        for (int node : graph.keySet()) {
            long componentCount = DFS(node, graph, visited);
            if (componentCount != 0) {
                componentsNodesCount.add(componentCount);
            }
        }

        long singletonsCount = count - graph.keySet().size();

        long pairsCombinations = 0;
        for (int i = 0; i < componentsNodesCount.size() - 1; i++) {
            pairsCombinations += componentsNodesCount.get(i) * singletonsCount;
            for (int j = i + 1; j < componentsNodesCount.size(); j++)
                pairsCombinations += componentsNodesCount.get(i) * componentsNodesCount.get(j);
        }

        if (singletonsCount > 0) {
            if (componentsNodesCount.size() > 0) {
                pairsCombinations += componentsNodesCount.get(componentsNodesCount.size() - 1) * singletonsCount;
            }

            pairsCombinations += (singletonsCount * (singletonsCount - 1)) / 2;
        }

        System.out.println(pairsCombinations);
    }

    private static int DFS(int node, Map<Integer, HashSet<Integer>> graph, boolean[] visited) {
        int result = 0;
        if (!visited[node]) {
            visited[node] = true;
            result++;
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    if (!visited[child]) {
                        result += DFS(child, graph, visited);
                    }
                }
            }
        }

        return result;
    }
}