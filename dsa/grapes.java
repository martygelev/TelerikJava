import java.math.BigInteger;
import java.util.Scanner;

public class grapes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        if (n == 0) {
            System.out.println(1);
            return;
        }

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= n; ++i) {
            dp[i] = BigInteger.ZERO;
            for (int j = 0; j < i; ++j) {
                dp[i] = dp[i].add(dp[j].multiply(dp[i - 1 - j])); // check
            }
        }

        System.out.println(dp[n]);
    }
}
