package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();


        int groupSpeed = in.nextInt();

        int groupLength = 1;
        int groupSum = groupSpeed;
        int bestLength = 1;
        int bestSum = groupSpeed;

        for (int i = 0; i < n - 1; i++) {
            int speed = in.nextInt();

            if (groupSpeed < speed) {
                groupLength++;
                groupSum += speed;
            } else {
                groupSpeed = speed;
                groupSum = speed;
                groupLength = 1;
            }
            if (bestLength < groupLength) {
                bestLength = groupLength;
                bestSum = groupSum;
            } else if (bestLength == groupLength) {
                bestSum = Math.max(bestSum, groupSum);
            }
        }

        System.out.println(bestSum);
    }
}