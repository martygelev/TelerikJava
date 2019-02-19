package com.telerikacademy.tasks.Recursion;

public class StringReverseRecursive {
    public static void main(String[] args) {
        String input = "TelerikAcademyNinjas";
        System.out.println(stringReverse(input));
    }

    private static String stringReverse(String text) {
        int length = text.length();
        if (length == 0) {
            return text;
        }
        return text.substring(length - 1) + stringReverse(text.substring(0, length - 1));
//        return stringReverse(text.substring(1, length)) + text.substring(0, 1);
    }
}
