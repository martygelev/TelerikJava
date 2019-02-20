import java.util.Scanner;
import java.util.Stack;

class BaseballGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ops = in.nextLine().split(", ");

        System.out.println(Solution.calPoints(ops));
    }

    static class Solution {
        public static int calPoints(String[] ops) {
            int sum = 0;

            Stack<Integer> points = new Stack<>();

            for (String op : ops) {
                if (isNumeric(op)) {
                    points.push(Integer.parseInt(op));
                } else if (op.charAt(0) == 'C') {
                    points.pop();
                } else if (op.charAt(0) == 'D') {
                    points.push(points.peek() * 2);
                } else if (op.charAt(0) == '+') {
                    int tempPopHolder = points.pop();
                    int tempPoints = tempPopHolder + points.peek();
                    points.push(tempPopHolder);
                    points.push(tempPoints);
                }
            }

            while (!points.empty()) {
                sum += points.pop();
            }

            return sum;
        }

        public static boolean isNumeric(String str) {
            for (char c : str.toCharArray()) {
                if (c != '-' && !Character.isDigit(c)) return false;
            }
            return true;
        }
    }
}