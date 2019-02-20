import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CombinationsV2 {
    private static void getCombinations(int n, int k, int start, int comboIndex, int[] combo) {
        if (comboIndex == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(combo[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int value = start; value <= n; value++) {
            combo[comboIndex] = value;
            getCombinations(n, k, value + 1, comboIndex + 1, combo);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = convert(input[0]);
        int k = convert(input[1]);

        getCombinations(n, k, 1, 0, new int[k]);


    }

    private static int convert(String s) {
        int value = 0;
        int flag = 2 - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }
}