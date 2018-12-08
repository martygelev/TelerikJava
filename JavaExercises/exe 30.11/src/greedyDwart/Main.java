package greedyDwart;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(", ");
        int[] valley = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int n= Integer.parseInt(in.nextLine());


        List<Integer> sums = new ArrayList<>();
        for (int i =0; i<n; i++)
        {
            int[] pattern = Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            int patternLenght = pattern.length;
            boolean[] visited = new boolean[valley.length];
            int startIndex =0;
            int sum=0;
            sum +=valley[startIndex];
            visited[startIndex]=true;
            int currentIndex=0;

            int j =0;

            while(true) // start from 1 maybe
            {
                if (j>patternLenght-1)
                {
                    j=0;
                }
                currentIndex +=pattern[j];
                if (currentIndex<0 || currentIndex>valley.length-1 || visited[currentIndex])
                {
                    break;
                }
                sum+=valley[currentIndex];
                visited[currentIndex]=true;
                j++;
            }

            sums.add(sum);

        }
        Collections.sort(sums);
        Collections.reverse(sums);
        System.out.println(sums.get(0));
    }
}
