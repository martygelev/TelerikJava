package com.telerikacademy.tasks.LinearDataStructures.Solutions;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare844Solution {

    /*
    Example 1:

    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    Example 2:

    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".
    Example 3:

    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
    Example 4:

    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
    Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.
     */

    private static void fakeInput() {
        String input = "ab#c"
                + System.lineSeparator() +
                "ad#c";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {

        fakeInput();
        Scanner in = new Scanner(System.in);
        String inputOne = in.nextLine();
        String inputTwo = in.nextLine();


        System.out.println(backspaceCompare1(inputOne, inputTwo));
    }

    private static boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '#' && !s.isEmpty()) {
                s.pop();
            } else if (ch != '#') {
                s.push(ch);
            }
        }
        for (char ch : T.toCharArray()) {
            if (ch == '#' && !t.isEmpty()) {
                t.pop();
            } else if (ch != '#') {
                t.push(ch);
            }
        }
        return s.toString().equals(t.toString());
    }

    private static boolean backspaceCompare1(String s, String t) {
        Stack<Character> sStack = getReducedStack(s);
        Stack<Character> tStack = getReducedStack(t);
        return sStack.toString().equals(tStack.toString());
    }

    private static Stack<Character> getReducedStack(String s) {
        Stack<Character> sStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c != '#') {
                sStack.push(c);
                continue;
            }

            if (!sStack.empty()) {
                sStack.pop();
            }
        }
        return sStack;
    }


}
