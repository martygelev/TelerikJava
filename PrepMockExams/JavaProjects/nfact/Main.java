package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NFactorialMemorization {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int inputNumber = in.nextInt();
        ArrayList<BigInteger> arr = new ArrayList<>();


        System.out.println(calc(inputNumber, arr));
    }

    static BigInteger calc(int n, ArrayList<BigInteger> arr) {

        if (n <= 1) {
            return BigInteger.ONE;

        }
        if (n < arr.size()) {

            return arr.get(n);


        }
        BigInteger factorial = calc(n - 1, arr).multiply(BigInteger.valueOf((long)n));
        arr.add(factorial);
        return factorial;

    }
}
