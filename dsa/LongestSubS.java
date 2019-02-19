package dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubS {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] sequence = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (Integer i : longestSequence(sequence)) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    private static List<Integer> longestSequence(int[] sequence) {
        List<Integer> bestSubsequence = new ArrayList<>();
        int bestStart = 0;
        int bestEnd = 0;
        int bestLength = 0;
        int currentStart = 0;
        int currentLength = 0;
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] == sequence[i - 1]) {
                currentLength++;
                if (currentLength > bestLength) {
                    bestLength = currentLength;
                    bestStart = currentStart;
                    bestEnd = i;
                }
            } else {
                currentStart = i;
                currentLength = 0;
            }
        }

        for (int i = bestStart; i <= bestEnd; i++) {
            bestSubsequence.add(sequence[i]);
        }

        return bestSubsequence;
    }

}
