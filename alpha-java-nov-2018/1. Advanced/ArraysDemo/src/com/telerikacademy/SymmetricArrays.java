package com.telerikacademy;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SymmetricArrays {

    static void fakeInput() {
        String test = "4\n" +
                "1 2 3 2 1\n" +
                "2 1\n" +
                "1 2 2 1\n" +
                "4";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            boolean isSymmetric = true;
            for (int j = 0; j < array.length / 2; j++) {
                if (!array[j].equals(array[array.length - j - 1])) {
                    isSymmetric = false;
                }
            }
            if (isSymmetric) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
