
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABoxFullOfBalls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] turns = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] aAndB = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = CalculateNumberOfWins(turns, aAndB[0], aAndB[1]);
        System.out.println(answer);
    }

    private static int CalculateNumberOfWins(int[] turns, int a, int b) {
        boolean[] isWinningCase = new boolean[b + 101];
        for (int i = 0; i <= b; i++) {
            if (!isWinningCase[i]) {
                for (int turn : turns) {
                    isWinningCase[i + turn] = true;
                }
            }
        }


        return 0;
    }
}
