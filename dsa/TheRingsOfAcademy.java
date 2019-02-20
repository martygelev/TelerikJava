package dsa;

import java.util.Scanner;

public class TheRingsOfAcademy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[] children = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(in.nextLine());
            children[parent]++;
        }

        long[] facts = new long[children.length + 1]; //children.max ?
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i;
        }

        long total = 1;
        for (int i = 1; i < children.length; i++) {
            total *= facts[children[i]];
        }

        System.out.println(total);
    }
}
