
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

 class Expressions {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(in.readLine());
        System.out.println(expression(num, sum, 1, num[0], 1, 0, false));
    }

    private static int expression(int[] digits, int expectedResult, int index, int currentNumber, int currentProduct, int currentSum, Boolean negative) {
        if(index == digits.length) {
            currentProduct *= currentNumber;
            currentSum += negative ? -currentProduct : currentProduct;

            if(currentSum == expectedResult) {
                return 1;
            }

            return 0;
        }
        int result = 0;
        int nextSum = currentSum + currentProduct * currentNumber * (negative ? -1 : 1);
        result += expression(digits, expectedResult, index + 1, digits[index], 1, nextSum, false);
        result += expression(digits, expectedResult, index + 1, digits[index], 1, nextSum, true);

        int nextProduct = currentProduct * currentNumber;
        result += expression(digits, expectedResult, index + 1, digits[index], nextProduct, currentSum, negative);

        if(currentNumber != 0) {
            int nextNumber = currentNumber * 10 + digits[index];
            result += expression(digits, expectedResult, index + 1, nextNumber, currentProduct, currentSum, negative);
        }
        return result;
    }
}
