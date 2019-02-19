import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;


 class Friends
{
    private static class Vertex
    {
        private int name;
        private int weight;

        public int getWeight()
        {
            return weight;
        }

        Vertex(int name, int weight)
        {
            this.name = name;
            this.weight = weight;
        }
    }

    private static int n;
    private static int m;
    private static int start;
    private static int end;
    private static int mid1;
    private static int mid2;
    private static Deque<Vertex>[] vertices;

    private static void addEdge(int from, int to, int weight)
    {
        addDirectedEdge(from, to, weight);
        addDirectedEdge(to, from, weight);
    }

    private static void addDirectedEdge(int from, int to, int weight)
    {
        if (vertices[from] == null)
            vertices[from] = new ArrayDeque<>();

        vertices[from].add(new Vertex(to, weight));
    }

    private static int getBestDistance()
    {
        int[] fromDistances = dijkstra(start, end, mid1, mid2);
        int[] endDistances = dijkstra(end, start, mid1, mid2);
        int[] m1Distances = dijkstra(mid1, start, end, mid2);
        int[] m2Distances = dijkstra(mid2, start, end, mid1);

        return Math.min(
                fromDistances[mid1] + endDistances[mid2] + m1Distances[mid2],
                fromDistances[mid2] + endDistances[mid1] + m2Distances[mid1]);
    }

    private static int[] dijkstra(int from, int to, int... exclude)
    {
        Set<Vertex> used = new HashSet<>();

        Arrays.stream(exclude)
                .forEach(v -> used.add(new Vertex(v, 0)));

        Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(Vertex::getWeight));

        int[] distances = Stream.generate(() -> Integer.MAX_VALUE)
                .limit(n)
                .mapToInt(Integer::valueOf)
                .toArray();

        distances[from] = 0;
        queue.offer(new Vertex(from, 0));

        while (!queue.isEmpty())
        {
            Vertex current = queue.poll();

            if (used.contains(current))
                continue;

            used.add(current);

            for (Vertex next : vertices[current.name])
            {
                int newDistance = distances[current.name] + next.weight;
                if (distances[next.name] > newDistance)
                {
                    distances[next.name] = newDistance;
                    queue.offer(new Vertex(next.name, newDistance));
                }
            }
        }

        return distances;
    }

    private static void readInput(BufferedReader reader) throws IOException
    {
        int[] nm = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        int[] se = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        start = se[0] - 1;
        end = se[1] - 1;

        int[] m1m2 = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mid1 = m1m2[0] - 1;
        mid2 = m1m2[1] - 1;

        vertices = new ArrayDeque[n];

        for (int i = 0; i < m; i++)
        {
            int[] edge = Arrays.stream(reader.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];

            addEdge(from, to, weight);
        }
    }

    private static void fakeInput()
    {
        String input = "18 30\n" +
                "1 17\n" +
                "11 4\n" +
                "1 8 15\n" +
                "1 9 1\n" +
                "1 14 100\n" +
                "2 4 100\n" +
                "2 8 10\n" +
                "2 9 100\n" +
                "3 9 100\n" +
                "3 10 3\n" +
                "3 14 1\n" +
                "4 9 1\n" +
                "4 10 3\n" +
                "4 11 1\n" +
                "5 11 6\n" +
                "5 16 7\n" +
                "6 7 1\n" +
                "6 11 1\n" +
                "6 15 7\n" +
                "6 16 1\n" +
                "7 11 3\n" +
                "7 15 2\n" +
                "7 18 1\n" +
                "8 18 1\n" +
                "10 12 4\n" +
                "10 13 6\n" +
                "11 12 5\n" +
                "12 13 10\n" +
                "12 17 100\n" +
                "13 14 2\n" +
                "15 16 10\n" +
                "16 17 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) throws IOException
    {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        readInput(reader);

        System.out.println(getBestDistance());
    }
}