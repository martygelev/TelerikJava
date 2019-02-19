import java.util.Scanner;

public class SuperMario {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strs = in.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        if (n < k)
        {
            System.out.println(0);
            return;
        }

        strs = in.nextLine().split(" ");
        int f = Integer.parseInt(strs[0]);
        int a = Integer.parseInt(strs[1]);
        int b = Integer.parseInt(strs[2]);
        int m = Integer.parseInt(strs[3]);

        int[] field = new int[n + 1];
        long[] memo = new long[n + 1];
        memo[0] = -1;
        memo[1] = -1;
        field[0] = 0;
        field[1] = f;
        for (int i = 2; i <= n; ++i)
        {
            field[i] = (int)(((long)field[i - 1] * a + b) % m);
            memo[i] = -1;
        }

        long result = MinJump(field, memo, k, 0, 0);
        System.out.println(result);
    }

    static long MinJump(int[] field, long[] memo, int k, int index, long sum)
    {
        if (index >= field.length)
        {
            return sum;
        }

        if (memo[index] > -1)
        {
            return memo[index];
        }

        Long best = Long.MAX_VALUE;
        for (int j = 1; j <= k; ++j)
        {
            long current = MinJump(field, memo, k, index + j, sum + field[index]);
            if (best > current)
            {
                best = current;
            }
        }

        memo[index] = best;
        return best;
    }
}
