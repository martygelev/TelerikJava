package javaAdvancedPart2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long first = in.nextLong();
        long second = in.nextLong();
        long third = in.nextLong();
        int n = in.nextInt();

        System.out.println(first);
        System.out.println(second + " " + third);


        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                long sum = first + second + third;
                first = second;
                second = third;
                third = sum;
                System.out.print(sum + " ");
            }
            System.out.println();
        }

    }
}
