package com.telerikacademy;

public class Main {
    public static void main(String[] args) {
        String str = "git is a <<version control>> system for tracking changes in <<computer files>> and coordinating work on those files among multiple people";

        while (str.contains("<<") && str.contains(">>")) {
            int start = str.indexOf("<<");
            int end = str.indexOf(">>");
            String phraseWithBrackets = str.substring(start, end + 2);
            String phrase = phraseWithBrackets.substring(2, phraseWithBrackets.length() - 2);
            str = str.replace(phraseWithBrackets, phrase.toUpperCase());
        }

        System.out.println(str);
    }
}