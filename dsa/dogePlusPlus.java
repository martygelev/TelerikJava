import java.util.Scanner;

public class dogePlusPlus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        boolean[][] wall = new boolean[n + 1][m + 1];

        str = in.nextLine().split(";");
        for (String x : str) {
            String[] s = x.split(" ");
            wall[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
        }

        long[][][] table = new long[k + 1][n][m];
        table[0][0][0] = 1;

        for (int t = 0; t <= k; ++t) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (wall[i][j]) {
                        continue;
                    }

                    if (i > 0) {
                        table[t][i][j] += table[t][i - 1][j];
                    }
                    if (j > 0) {
                        table[t][i][j] += table[t][i][j - 1];
                    }
                    if (t > 0) {
                        if (i < n - 1) {
                            table[t][i][j] += table[t - 1][i + 1][j];
                        }
                        if (j < m - 1) {
                            table[t][i][j] += table[t - 1][i][j + 1];
                        }
                    }
                }
            }
        }

        long total = 0;
        for (int i = 0; i <= k; ++i) {
            total += table[i][n - 1][m - 1];
        }

        System.out.println(total);
    }
}
