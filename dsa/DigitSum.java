import java.math.BigInteger;
import java.util.Scanner;

public class DigitSum {
    static int digitSum(String n, int k) {
        String number = getNumber(n, k);
        int answer = findSuperDigit(number);
        return answer;
    }

    private static String getNumber(String n, int k) {
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < k; i++) {
            concat.append(n);
        }
        return concat.toString();
    }

    private static int findSuperDigit(String number) {
        if (number.length() == 1) {
            return Integer.parseInt(number);
        }

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < number.length(); i++) {
            sum = sum.add(BigInteger.valueOf(number.charAt(i) - '0'));
        }

        String nextNumber = String.valueOf(sum);

        return findSuperDigit(nextNumber);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = digitSum(n, k);
        System.out.println(result);
        in.close();
    }
}