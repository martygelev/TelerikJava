import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SquaresGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());

        if (n < m) {
            int k = n;
            n = m;
            m = k;
        }

        List<Integer> masks = new ArrayList<>();
        for (int i = 0; i < (1 << m); ++i) {
            if ((i & (i >> 1)) > 0) {
                continue;
            }

            masks.add(i);
        }

        BigInteger[][] dp = new BigInteger[2][masks.size()];
        dp[0][0] = BigInteger.ONE;

        for (int row = 1; row <= n; ++row) {
            for (int i = 0; i < masks.size(); ++i) {
                BigInteger from = dp[(row - 1) % 2][i];
                dp[(row - 1) % 2][i] = BigInteger.ZERO;

                for (int j = 0; j < masks.size(); ++j) {
                    if ((masks.get(i) & masks.get(j)) > 0) {
                        continue;
                    }

                    dp[row % 2][j] = dp[row % 2][j].add(from);
                }
            }
        }

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < masks.size(); ++i) {
            result = result.add(dp[n % 2][i]);
        }
        System.out.println(result);

    }
}

/*
1
1
 */// -> 2
