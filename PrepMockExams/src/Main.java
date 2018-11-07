import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int inputNumber = in.nextInt();
        double x = in.nextDouble();

        double fact = 1;
        double total = 1;

        for (int i = 1; i <= inputNumber; i++) {

            fact *= i;
            total += fact / Math.pow(x, i);
        }
        System.out.printf("%.5f", total);
    }

}