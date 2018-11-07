package com.company;

package IfElse;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class KaspichanNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();
        String[] kaspichan = new String[256];

        Arrays.fill(kaspichan, "");

        for (int i = 0; i < 26; i++) {
            kaspichan[i] += (char) (i + 'A');
        }
        int index = 26;
        for (char i = 'a'; i <= 'i'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {

                kaspichan[index] += String.valueOf(i) + String.valueOf(j);

                if (i == 'i' && j == 'V') {
                    break;
                }
                index++;
            }
        }
        if (n.equals(BigInteger.ZERO)) {
            System.out.println("A");
        } else {
            String kaspichanNum = "";

            while (!n.equals(BigInteger.ZERO)) {

                BigInteger intIndex = n.mod(BigInteger.valueOf(256));
                kaspichanNum = kaspichan[intIndex.intValue()] + kaspichanNum;
                n = n.divide(BigInteger.valueOf(256));
            }

            System.out.println(kaspichanNum);
        }
    }

}
