import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxPath {
    private static long maxSum = 0;
    private static long bestNode = 0;
    private static Map<Long, Set<Long>> tree = new HashMap<>();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        tree = readTree();
        Iterator iter = tree.keySet().iterator();
        long nodeStart = (long)iter.next();

        dfs(nodeStart, -1, 0);
        maxSum = 0;
        dfs(bestNode, -1, 0);

        System.out.println(maxSum);
    }

    public static void dfs(long node, long prev, long tempSum) {
        boolean hasNext = false;
        long nodeSum = tempSum + node;
        for (long child : tree.get(node)) {
            if (child != prev) {
                hasNext = true;
                dfs(child, node, nodeSum);
            }
        }

        if (!hasNext) {
            if (nodeSum > maxSum) {
                maxSum = nodeSum;
                bestNode = node;
            }
        }
    }

    private static Map<Long, Set<Long>> readTree() throws IOException {
        long n = Long.parseLong(in.readLine());

        for (long i = 0; i < n - 1; i++) {
            String input = in.readLine();
            String[] split = input
                    .substring(1, input.length()-1)
                    .split(" <- ");

            long parent = Long.parseLong(split[0]);
            long child = Long.parseLong(split[1]);

            if (!tree.containsKey(parent)) {
                tree.put(parent, new HashSet<>());
            }
            tree.get(parent).add(child);

            if (!tree.containsKey(child)) {
                tree.put(child, new HashSet<>());
            }
            tree.get(child).add(parent);

        }
        return tree;
    }
}