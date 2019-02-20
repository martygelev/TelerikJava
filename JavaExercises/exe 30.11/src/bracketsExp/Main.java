package bracketsExp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        char[] inputArr = input.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (inputArr[i] == '(') {
                stack.push(i);

            }
            if (inputArr[i] == ')') {
                int indexOut = i;
                String output = input.substring(stack.pop(), indexOut + 1);
                System.out.println(output);
            }
        }
    }
}
