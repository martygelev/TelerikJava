

/*

import java.util.*;

    public class Packages {

        static Set<Integer> checked = new HashSet<>();
        static Map<Integer, HashSet<Integer>> map = new TreeMap<>();

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = Integer.parseInt(in.nextLine());

            for (int i = 0; i < n; i++) {
                int p = in.nextInt();
                if(!map.containsKey(p)){
                    map.put(p, new HashSet<>());
                }

                map.get(p).add(Integer.parseInt(in.nextLine().trim()));
            }

            n = Integer.parseInt(in.nextLine());
            int[] packages = new int[n];
             checked = new HashSet<>();
            for (int i = 0; i < n; i++) {
                packages[i] = Integer.parseInt(in.nextLine());
            }

            for (int curPac : packages) {
                TreeSet<Integer> result = new TreeSet<>(recursion(curPac));
                result.add(curPac);
                for (Integer x : result) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }

        }

        private static HashSet<Integer> recursion(Integer pack){
            if(!map.containsKey(pack)){
                return new HashSet<>();
            }

            if(checked.contains(pack)){
                return map.get(pack);
            }

            Queue<Integer> queue= new LinkedList<>(map.get(pack));
            while(!queue.isEmpty()){
                map.get(pack).addAll(recursion(queue.poll()));
            }
            checked.add(pack);
            return map.get(pack);
        }
    }

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Packages {
    private static List<Integer> visited;
    private static Map<Integer, List<Integer>> graph;
    private static SortedSet<Integer> sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        graph = new HashMap<>();
        visited = new ArrayList<>();
        sorted = new TreeSet<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            int[] pd = Arrays.stream(reader.readLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (!graph.containsKey(pd[0]))
                graph.put(pd[0], new ArrayList<>());

            graph.get(pd[0]).add(pd[1]);
        }

        int packages = Integer.parseInt(reader.readLine());
        for (int i = 0; i < packages; i++) {
            dfs(Integer.parseInt(reader.readLine()));

            System.out.println(
                    sorted.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")));

            visited.clear();
            sorted.clear();
        }
    }

    private static void dfs(int packageToInstall) {
        List<Integer> currentVertex = graph.get(packageToInstall);

        visited.add(packageToInstall);

        if (currentVertex == null) {
            sorted.add(packageToInstall);
            return;
        }

        for (Integer vertex : currentVertex) {
            if (visited.contains(vertex))
                continue;

            dfs(vertex);
        }

        sorted.add(packageToInstall);
    }
}
