package com.telerikacademy;

import java.util.Scanner;

public class TribonacciTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t1 = scanner.nextInt();
        long t2 = scanner.nextInt();
        long t3 = scanner.nextInt();
        int linesCount = scanner.nextByte();

        System.out.printf("%d\n%d %d\n", t1, t2, t3);

        int lineLimit = 3;
        for (int lineNumber = 2; lineNumber < linesCount; lineNumber++) {
            String line = "";
            for (int i = 0; i < lineLimit; i++) {
                long tNext = t1 + t2 + t3;
                line += tNext + " ";
                t1 = t2;
                t2 = t3;
                t3 = tNext;
            }
            System.out.println(line.trim());
            lineLimit++;
        }
    }
}
