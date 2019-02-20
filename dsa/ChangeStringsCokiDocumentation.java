package dsa;

import java.util.Scanner;

public class ChangeStringsCokiDocumentation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String text = in.nextLine().toLowerCase();
        int operations = 0;
        int englishCharactersCount = 26;
        int minCharValue = 97;
        int maxCharValue = 122;

        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            int leftChar = text.toCharArray()[left];
            int rightChar = text.toCharArray()[right];

            while ((leftChar < minCharValue || leftChar > maxCharValue) && left < right) {
                left++;
                leftChar = text.toCharArray()[left];
            }

            while ((rightChar < minCharValue || rightChar > maxCharValue) && left < right) {
                right--;
                rightChar = text.toCharArray()[right];
            }

            if (left >= right) {
                break;
            }

            int diff = Math.abs(text.toCharArray()[left] - text.toCharArray()[right]);
            operations += Math.min(diff, englishCharactersCount - diff);

            left++;
            right--;
        }

        System.out.println(operations);
    }
}
