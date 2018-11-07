package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        String line = scan.nextLine();
        String[] str = line.trim().split("");
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>(Arrays.asList(str));

        for (int i = 0; i < 10; i++) {
            numbers.add(0);
        }
        returnNumber(date, numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
    }

    static void returnNumber(ArrayList<String> date, ArrayList<Integer> numbers) {
        if (date.size() == 1) {
            numbers.set(Integer.parseInt(date.get(0)), numbers.get(Integer.parseInt(date.get(0))) + 1);
            return;
        }

        for (int i = 0; i < date.size() - 1; i++) {

            int a = Integer.parseInt(date.get(i));
            int b = Integer.parseInt(date.get(i + 1));
            int c = ((a + b) * (a ^ b)) % 10;
            date.remove(i);
            date.remove(i+1);
            ArrayList<String> nextNumber = new ArrayList<>();
            nextNumber.add(String.valueOf(c));
            for (int j = 0; j < date.size(); j++) {
                nextNumber.add(String.valueOf(date.get(j)));
            }
            returnNumber(nextNumber, numbers);
        }
        return;
    }
}