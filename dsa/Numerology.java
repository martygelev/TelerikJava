import java.util.Arrays;
import java.util.Scanner;

public class Numerology {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digits = in.nextLine();
        int[] counts = new int[10];

        numerology(digits, counts);
        Arrays.stream(counts).forEach(count -> System.out.print(count + " "));
    }

    public static void numerology(String digits, int[] counts) {
        if (digits.length() == 1) {
            int result = digits.charAt(0) - '0';
            counts[result]++;
            return;
        }

        for (int i = 0; i < digits.length() - 1; i++) {
            int a = digits.charAt(i) - '0';
            int b = digits.charAt(i + 1) - '0';
            int c = (a + b) * (a ^ b) % 10;

            String first = digits.substring(0, i);
            String last = digits.substring(i + 2);
            String nextNumber = first + c + last;
            numerology(nextNumber, counts);
        }
    }
}
