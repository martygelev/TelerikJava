package com.telerikacademy.tasks.Recursion;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(factorialBigInt(BigInteger.valueOf(16000)));
    }

    private static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static BigInteger factorialBigInt(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return number = number
                .multiply(
                        factorialBigInt(
                                number
                                        .subtract(BigInteger.ONE)));
    }
}
