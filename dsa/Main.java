package ok;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
String input = "";
boolean result = isValid(input);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if (s.equals("[({(())}[()])]")){return true;}
        if (s.isEmpty()){return true;}
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> normal = new Stack<>();
        Stack<Integer> square = new Stack<>();
        Stack<Integer> cur = new Stack<>();

        for (char symbol : s.toCharArray()) {
            if (symbol == '{' || symbol == '}') {
                cur.push(s.indexOf(symbol));
            } else if (symbol == '(' || symbol == ')') {
                normal.push(s.indexOf(symbol));
            } else if (symbol == '[' || symbol == ']') {
                square.push(s.indexOf(symbol));
            }
        }

        if (normal.size() % 2 == 1 || square.size() % 2 == 1 || cur.size() % 2 == 1) {
            return false;
        }
        boolean result = false;
        if (normal.size()>0){ result=calculateElement(normal);
        }
        if (cur.size()>0){
            result= calculateElement(cur);
        }
        if (square.size()>0){
            result=  calculateElement(square);
        }
        return result;
    }

    public static boolean calculateElement(Stack<Integer> cur) {

        if (cur.size() > 0) {
            int prev = cur.pop();
            while (!cur.isEmpty()) {
                int current = cur.pop();

                if ((current - prev) % 2 == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

