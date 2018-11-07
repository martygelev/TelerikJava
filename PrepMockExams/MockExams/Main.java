package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Balanced_numbers {
    public static int givenNumber;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            givenNumber = Integer.parseInt(reader.readLine());
            if (isBalanced(givenNumber)) {
                sum += givenNumber;
            } else {
                break;
            }
        }
        System.out.println(sum);
    }

    public static boolean isBalanced(int number) {
        int last_digit = number % 10;
        number = number / 10;
        int second_digit = number % 10;
        number = number / 10;
        int first_digit = number % 10;
        if (second_digit == (first_digit + last_digit)) {
            return true;
        } else {
            return false;
        }


    }
}
