package com.telerikacademy.tasks.LinearDataStructures.Solutions;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses20Solution {

     /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:

    Input: "()"
    Output: true

    Example 2:

    Input: "()[]{}"
    Output: true

    Example 3:

    Input: "(]"
    Output: false

    Example 4:

    Input: "([)]"
    Output: false

    Example 5:

    Input: "{[]}"
    Output: true
     */


    private static void fakeInput() {
        String input = "([)]";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    public static void main(String[] args) {

        fakeInput();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println(isValid(input));
    }

    private static boolean isValid(String s) {
        Stack<Character> expectedClosure = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                expectedClosure.push(')');
                continue;
            }
            if (ch == '[') {
                expectedClosure.push(']');
                continue;
            }
            if (ch == '{') {
                expectedClosure.push('}');
                continue;
            }
            if ((ch == ')' || ch == ']' || ch == '}') && expectedClosure.isEmpty()) {
                return false;
            }
            if (ch == expectedClosure.pop()) {
                continue;
            } else {
                return false;
            }
        }
        if (expectedClosure.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isValid1(String s) {
        Stack<Character> workingStack = new Stack<>();
        ArrayList<Character> startParentheses = new ArrayList<>(
                Arrays.asList('(', '[', '{')
        );
        ArrayList<Character> endParentheses = new ArrayList<>(
                Arrays.asList(')', ']', '}')
        );

        for (Character elem : s.toCharArray()) {
            int indexStart = startParentheses.indexOf(elem);
            if (indexStart != -1) {
                workingStack.push(endParentheses.get(indexStart));
                continue;
            }

            int indexEnd = endParentheses.indexOf(elem);
            if ((indexEnd != -1 && workingStack.empty()) || indexEnd == -1) {
                return false;
            }

            if (elem == workingStack.pop()) {
                continue;
            } else {
                return false;
            }
        }

        return workingStack.empty();
    }
}
