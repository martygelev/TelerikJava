package ok;

import java.util.Arrays;
import java.util.Scanner;

public class GoldFevorDim4ou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] days = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long sum = 0;
        int currentMax = 0;

        for (int j = days.length - 1; j > -1; j--) {
            if (days[j] > currentMax) {
                currentMax = days[j];
                continue;
            }

            sum += currentMax - days[j];
        }

        System.out.println(sum);
    }
}
