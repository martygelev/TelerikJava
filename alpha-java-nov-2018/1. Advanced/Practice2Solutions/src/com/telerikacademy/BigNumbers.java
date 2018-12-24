package com.telerikacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        String[] array1 = in.readLine().split(" ");
        String[] array2 = in.readLine().split(" ");
        int[] sum = new int[Math.max(array1.length, array2.length)];
        for (int i = 0; i < sum.length; i++) {
            if (i < array1.length)
                sum[i] += Integer.parseInt(array1[i]);
            if (i < array2.length)
                sum[i] += Integer.parseInt(array2[i]);
            if (sum[i] > 9) {
                sum[i] %= 10;
                if (i < sum.length)
                    sum[i + 1] += 1;
            }
            System.out.print(sum[i] + " ");
        }
    }
}