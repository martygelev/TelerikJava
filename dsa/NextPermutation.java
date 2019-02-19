package ok;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[]arr =Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int last = arr[arr.length-1];
        int prev = arr[arr.length-2];
        arr[arr.length-1]=prev;
        arr[arr.length-2]=last;

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
