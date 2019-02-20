import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Ranks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] numbers = new Integer[n];
        Integer[] numbersTosort = new Integer[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
            numbersTosort[i] = numbers[i];
        }
        Arrays.sort(numbersTosort, Comparator.reverseOrder());

        for (int i = 0; i < numbers.length; i++) {
            int index = 0;
            for (int j = 0; j < numbersTosort.length; j++) {
                if (numbersTosort[j].equals(numbers[i])) {
                    index = j;
                    break;
                }
            }
            numbers[i] = index + 1;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}