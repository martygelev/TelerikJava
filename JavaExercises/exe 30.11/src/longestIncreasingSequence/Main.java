package longestIncreasingSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<Integer> list = new ArrayList<>();

       String[] input = scanner.nextLine().split(" ");

        for (int i =0; i<input.length; i++)
        {
            list.add(Integer.parseInt(input[i]));
        }

        Collections.sort(list);
        Collections.reverse(list);

        int sum = list.get(0)+list.get(input.length-1);
        System.out.println(sum);
    }


}
