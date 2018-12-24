package com.telerikacademy;

public class StringsBenchMark {
    public static void main(String[] args) {
        long beginTime, elapsedTime;

        String str = "";
        int size = 16536;
        char ch = 'a';
        beginTime = System.nanoTime();
        // abcde...xyzabcde....
        for (int count = 0; count < size; count++) {
            str += ch;
            ch++;
            if (ch > 'z') {
                ch = 'a';
            }
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (Build String)");

        // Reverse a String by building another String character-by-character in the reverse order
        String strReverse = "";
        beginTime = System.nanoTime();
        for (int pos = str.length() - 1; pos >= 0; pos--) {
            strReverse += str.charAt(pos);   // Concatenate
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (Using String to reverse)");

        // Reverse a String via an empty StringBuilder by appending characters in the reverse order
        beginTime = System.nanoTime();
        StringBuilder sBuilderReverse = new StringBuilder(size);
        for (int pos = str.length() - 1; pos >= 0; pos--) {
            sBuilderReverse.append(str.charAt(pos));
        }
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (Using StringBuilder to reverse)");

        // Reverse a String by creating a StringBuilder with the given String and invoke its reverse()
        beginTime = System.nanoTime();
        StringBuilder sBuilderReverseMethod = new StringBuilder(str);
        sBuilderReverseMethod.reverse();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("Elapsed Time is " + elapsedTime / 1000 + " usec (Using StringBuidler's reverse() method)");
    }
}