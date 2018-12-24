package com.telerikacademy;

import java.util.Scanner;

public class LongestSequenceOfEqual {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int maxLength = 1;
        int currentLength = 1;
        int currentElement = numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i] == currentElement) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentElement = numbers[i];
                currentLength = 1;
            }
        }

        System.out.println(maxLength);
    }
}