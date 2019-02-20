package towersOfHanoi;

import java.util.Scanner;

public class Towers {
    public static int step = 1;

    public static void main(String[] args) {
        System.out.print("Enter number of discs: ");

        Scanner scanner = new Scanner(System.in);
        int numberOfDiscs = scanner.nextInt();

        shift(numberOfDiscs, "Pole1", "Pole2", "Pole3");
    }

    public static void shift(int n, String startPole, String intermediatePole, String endPole) {

        if (n == 0) {
            return;
        }
        shift(n - 1, startPole, endPole, intermediatePole);
        System.out.println("Step #" + step++ + ": Move  disc \"" + n + "\" from " + startPole + " --> " + endPole);
        shift(n - 1, intermediatePole, startPole, endPole);
    }

}
