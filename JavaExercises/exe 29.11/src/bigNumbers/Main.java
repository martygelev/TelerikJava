package bigNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int next;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int[] first = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int[] second = Arrays.stream(reader.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

        int[] biggerF = first.clone();
        int[] biggerS = second.clone();

        if (biggerF.length > biggerS.length) {
            biggerS = biggerF.clone();
        }
        int minElement = Math.min(first.length, second.length);
        int maxElement = Math.max(first.length, second.length);

        int[] result = new int[maxElement];
        next = 0;
        for (int i = 0; i < minElement; i++) {
            int res = first[i] + second[i] + next;
            next = 0;
            if (res > 9) {
                res %= 10;
                next += 1;
            }
            result[i] = res;

        }
        if (first.length != second.length) {
            for (int i = minElement; i < maxElement; i++) {
                result[i] = biggerS[i] + next;
                if (result[i] > 9) {
                    result[i] %= 10;
                    next = 1;
                    continue;
                }
                next = 0;
            }
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}