import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PenguinAirlines {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);


        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; ++i)
        {
            String line = in.nextLine();
            if (line == "None")
            {
                //adjList[i] = new ArrayList<>();
            }
            else
            {
             //  adjList[i] = line.Split(' ')
             //          .Select(int.Parse)
             //          .ToList();
            }
        }

        int[] componentId = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
              //  Dfs(i, adjList, visited, i, componentId);
            }
        }


        while (true)
        {
            String  line = in.nextLine();
            if (line.charAt(0) == 'H')
            {
                break;
            }

            String[] strs = line.split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);

            if (componentId[a] == componentId[b])
            {
                //if (adjList[a].contains(b))
                {
                    System.out.println("There is a direct flight.");
                }
              //  else
                {
                    System.out.println("There are flights, unfortunately they are not direct, grandma :(");
                }
            }
            else
            {
                System.out.println("No flights available.");
            }
        }

    }
    static void Dfs(int x, List<Integer>[] adjList, boolean[] visited, int id, int[] componentId)
    {
        visited[x] = true;
        componentId[x] = id;

        for (int z : adjList[x])
        {
            if (!visited[z])
            {
                Dfs(z, adjList, visited, id, componentId);
            }
        }
    }
}
