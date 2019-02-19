import java.util.Arrays;
import java.util.Scanner;

public class OfficeSpaceGo {
    private static int[] maxPathFrom;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] time = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] adjacencyMatrix = new boolean[n][n]; // 0-based matrix to represent the graph
        for (int i = 0; i < n; i++)
        {
            int[] requirements = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (requirements[0] != 0)
            {
                for (int requirement : requirements)
                {
                    adjacencyMatrix[requirement - 1][i] = true;
                }
            }
        }

        int minTime = FindMinTime(n, time, adjacencyMatrix);
        System.out.println(minTime);
    }
    private static int FindMinTime(int n, int[] time, boolean[][] adjacencyMatrix)
    {
        maxPathFrom = new int[n];
        boolean loopFound = false;

        int maxPath = 0;
        for (int i = 0; i < n; i++)
        {
            maxPath = Math.max(Dfs(i, time, adjacencyMatrix, new boolean[n], loopFound), maxPath);
            if (loopFound)
            {
                return -1;
            }
        }

        return maxPath;
    }

    private static int Dfs(int node, int[] time, boolean[][] adjacencyMatrix, boolean[] visited,  boolean loopFound)
    {
        if (visited[node])
        {
            loopFound = true;
            return 0;
        }

        if (!visited[node] && maxPathFrom[node] > 0)
        {
            return maxPathFrom[node];
        }

        visited[node] = true;
        maxPathFrom[node] = time[node];
        for (int v = 0; v < time.length; v++)
        {
            if (adjacencyMatrix[v][node])
            {
                maxPathFrom[node] = Math.max(
                        maxPathFrom[node],
                        Dfs(v, time, adjacencyMatrix, visited, loopFound) + time[node]);
            }
        }

        visited[node] = false;
        return maxPathFrom[node];
    }

}
/*
3
4 8 16
3
1
2
 */
