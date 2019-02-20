package ok;

public class HappyNumbers {
    public static void main(String[] args) {
        int n = 2;
        boolean isAHappyNumber = isHappy(n);
        System.out.println(isAHappyNumber);
    }

    public static boolean isHappy(int n) {
        int counter = 0;
        while (true) {
            counter++;
            if (n == 1) {
                return true;
            }
            if (counter > 100) return false;
            int length = String.valueOf(n).length();
            int result = 0;
            for (int i = 0; i < length; i++) {
                int digit = n % 10;
                n /= 10;
                result += digit * digit;
            }
            n = result;

        }
    }
}
