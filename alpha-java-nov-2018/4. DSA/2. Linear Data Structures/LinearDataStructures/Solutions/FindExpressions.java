package com.telerikacademy.tasks.LinearDataStructures.Solutions;

import java.util.*;

public class FindExpressions {

    /*
    We are given arithmetical expression with nested brackets:
    1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

    Extract all sub-expressions in brackets:
    (2 + 3)
    (3 + 1)
    (2 - (2 + 3) * 4 / (3 + 1))

    * */

    public static void main(String[] args) {
        String input = "1+(2-(2+3)*4/(3+1))*5";
       // List<String> result = getSubExpressionsIndices(input.toCharArray(), input);
       // result.forEach(System.out::println);
        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='(') stack.push(i);
            else if (input.charAt(i)==')')
                System.out.println(input.substring((Integer) stack.pop(), i+1));
        }
    }

    static List<String> getSubExpressions(char[] expression) {
        Stack<String> workingStack = new Stack<>();
        Stack<String> subExpression = new Stack<>();
        List<String> result = new ArrayList<>();
        int openCount = 0;

        for (int i = 0; i < expression.length; i++) {

            if (expression[i] != ')') {
                if (expression[i] == '(') {
                    openCount++;
                }

                workingStack.push(Character.toString(expression[i]));
                continue;
            }

            subExpression.push(")");
            openCount--;

            while (!workingStack.peek().equals("(")) {
                String elem = workingStack.pop();
                subExpression.push(elem);
            }

            // add '('
            String elem = workingStack.pop();
            subExpression.push(elem);


            String temp = "";
            while (!subExpression.empty()) {
                temp += subExpression.pop();
            }

            result.add(temp);
            if (openCount > 0) {
                workingStack.push(temp);
            }
        }

        return result;
    }

    static List<String> getSubExpressionsIndices(char[] expression, String expressionString) {
        Stack<Integer> openingBrackets = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < expression.length; i++) {

            if (expression[i] == '(') {
                openingBrackets.push(i);
            }

            if (expression[i] == ')') {
                result.add(expressionString.substring(openingBrackets.pop(), i + 1));
            }
        }

        return result;
    }
}
