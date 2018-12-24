package com.telerikacademy;

import java.util.Scanner;

public class Indices1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int current = 0;
        boolean[] used = new boolean[n];
        StringBuilder result = new StringBuilder("");
        while (true) {
            result.append(current).append(" ");
            used[current] = true;
            current = arr[current];

            if (current < 0 || current >= n) {
                System.out.println(result.toString());
                break;
            }
            if (used[current]) {
                String resultString = result.toString();
                resultString += ")";
                String nextString = Integer.toString(current);
                if (resultString.startsWith(nextString + " ")) {
                    resultString = "(" + resultString;
                } else {
                    resultString = resultString.replace(" " + nextString + " ", " (" + nextString + " ");
                }

                resultString = resultString.replace(" (", "(");
                resultString = resultString.replace(" )", ")");

                System.out.println(resultString);
                break;
            }
        }
    }
}
