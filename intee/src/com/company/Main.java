package com.company;

import java.util.*;

public class Main {

    static int col;
    static int row;
    static String[][] trans_arr = new String[col][row];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int m = sc.nextInt();
        row = m;
        System.out.println("Enter cols");
        int n = sc.nextInt();
        col = n;
        String[][] arr = new String[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.next();
            }
        }
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[j].length / 2; i++) {
                String temp = arr[j][i];
                arr[j][i] = arr[j][arr[j].length - i - 1];
                arr[j][arr[j].length - i - 1] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
