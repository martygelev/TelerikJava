/*
Given a list of strings, each string can be one of the 4 following types:
Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.
You need to return the sum of the points you could get in all the rounds.
Example :
Input: ["5","2","C","D","+"]
Output: 30
Explanation:
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 */

import java.util.Stack;

public class Baseball {

    public static int calPoints(String[] ops) {

        Stack<Integer> gosho = new Stack<>();

        boolean flag;

        for (String str : ops) {
            switch (str) {

                case "C":

                case "D":

                case "+":

                    flag = false;
                    break;

                default:
                    flag = true;
            }

            if (flag) {

                gosho.push(Integer.parseInt(str));

            } else {

                if (str == "C")
                    gosho.pop();

                if (str == "D")
                    gosho.push((gosho.peek() * 2));

                if (str == "+") {
                    int temp1 = gosho.pop();
                    int temp2 = gosho.pop();
                    gosho.push(temp2);
                    gosho.push(temp1);
                    gosho.push((temp1 + temp2));
                }

            }

        }


        int result = 0;

        while (!gosho.empty()) {
            result += gosho.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(arr));
    }
}