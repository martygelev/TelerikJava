import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

 class ExpressionRec {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numbers = in.nextLine();
        int expectedResult = Integer.parseInt(in.nextLine());

        System.out.println(getExps(numbers, expectedResult));
    }

    static void getExpression(ArrayList<String> list, String curExp, String input, int target, int position, int curValue, int last){
        if (position==input.length()){
            if (curValue==target){
                list.add(curExp);
            }
            return ;
        }

        for (int i = position; i < input.length(); i++) {
            if (i!=position && input.charAt(position)=='0'){
                break;
            }
            String part = input.substring(position, i+1);
            int cur = evaluate(part);

            if (position==0){
                getExpression(list, curExp+part, input, target, i+1, cur, cur);
            }
            else{
                getExpression(list, cur+"+"+part, input, target, i+1, curValue+cur, cur);
                getExpression(list, cur+"-"+part, input, target, i+1, curValue-cur, -cur);
                getExpression(list, cur+"*"+part, input, target, i+1, curValue*cur, last*cur);
            }
        }

    }
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuilder sbuf = new StringBuilder();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    static int getExps(String input, int target){
        ArrayList<String> list = new ArrayList<>();
        getExpression(list, "", input, target, 0,0,0);
        return list.size();
    }
}