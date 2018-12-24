package com.telerikacademy;

import java.util.Scanner;

public class Indices2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] stringNumbers = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringNumbers[i]);
        }

        int resultSize = 0;
        int[] resut = new int[n];
        boolean[] usedPositions = new boolean[n];

        boolean hasCycle = false;
        int currentPosition = 0;
        int cycleStartIndex = -1;
        while (true) {
            resut[resultSize] = currentPosition;
            resultSize++;
            usedPositions[currentPosition] = true;
            currentPosition = arr[currentPosition];

            if (currentPosition < 0 || currentPosition >= n) {
                break;
            }

            if (usedPositions[currentPosition]) {
                for (int i = 0; i < resultSize; i++) {
                    if (currentPosition == resut[i]) {
                        cycleStartIndex = i;
                        break;
                    }
                }
                hasCycle = true;
                break;
            }
        }

        StringBuilder resultString = new StringBuilder("");
        for (int i = 0; i < resultSize; i++) {
            if (hasCycle && i == cycleStartIndex) {
                resultString.append("(");
            }
            resultString.append(resut[i]);
            resultString.append(" ");
        }
        String finalResult = resultString.toString();
        if (hasCycle) {
            finalResult += ")";
            finalResult = finalResult.replace(" (", "(");
            finalResult = finalResult.replace(" )", ")");
        }

        System.out.println(finalResult);
    }
}
