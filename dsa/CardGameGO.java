import java.util.Arrays;
import java.util.Scanner;

public class CardGameGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] numbers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n][n];

        for (int length = 3; length <= n; length++)
        {
            for (int i = 0; i <= n - length; i++)
            {
                for (int j = i + 1; j < i + length - 1; j++)
                {
                    int current = dp[i][ j] + dp[j][ i + length - 1]
                    + numbers[j] * (numbers[i] + numbers[i + length - 1]);

                    if (dp[i][ i + length - 1] < current)
                    {
                        dp[i][ i + length - 1] = current;
                    }
                }
            }
        }

        System.out.println(dp[0][ n - 1]);
    }

}
