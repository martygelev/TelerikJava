package dsa;

import java.util.Stack;

public class points {
    public static void main(String[] args) {

    }
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String str : ops) {

            switch (str){
                case "+":
                   int prevElement = stack.pop();
                   int nextElement = prevElement + stack.peek();
                   stack.push(prevElement);
                   stack.push(nextElement);
                   break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(2*stack.peek());
                    break;

                default:
                        stack.push(Integer.valueOf(str));
            }
        }

        int sum = 0;
        for (Integer integer : stack) {
            sum+=integer;

        }

        return sum;

    }
}
