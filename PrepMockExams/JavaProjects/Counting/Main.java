package com.company;


import java.math.BigInteger;
import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder num = new StringBuilder();
        StringBuilder sb = new StringBuilder(in.nextLine());
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))){
                num.append(sb.charAt(i));
            }
        }
        BigInteger number = new BigInteger(num.toString());
        number = number.add(BigInteger.ONE);
        for (int i = 0; i < 10; i++) {
            System.out.println(number);
            number = number.add(BigInteger.ONE);
        }
    }
}