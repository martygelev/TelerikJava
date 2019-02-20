import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class DiShopPathFinder {
    static Scanner in = new Scanner(System.in);

    static int[] dRows = {-1, +1, +1, -1};
    static int[] dCols = {+1, +1, -1, -1};
    static boolean[][] isVisited;

    static int GetDirection(String directionName) {
        switch (directionName) {
            case "UR":
            case "RU":
                return 0;
            case "DR":
            case "RD":
                return 1;
            case "DL":
            case "LD":
                return 2;
            case "UL":
            case "LU":
                return 3;
        }
        return -1;
    }

    static long GetValue(int row, int col, int rows) {
        if (isVisited[row][col]) {
            return 0;
        }
        return 3 * (rows - row - 1 + col);
    }

    static boolean InRange(int value, int max) {
        return 0 <= value && value <= max;
    }

    public static void Solve() {
        int[] rowsCols = Arrays.stream(in.nextLine()
                .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsCols[0];
        int cols = rowsCols[1];
        isVisited = new boolean[rows][cols];

        int row = rows - 1;
        int col = 0;

        int n = Integer.parseInt(in.nextLine());
        long sum = 0;

        for (int i = 0; i < n; i++) {
            String[] dirNameAndMoves = in.nextLine().split(" ");
            String dirName = dirNameAndMoves[0];
            int dir = GetDirection(dirName);
            int moves = Integer.parseInt(dirNameAndMoves[1]);
            for (int j = 0; j < moves - 1; j++) {
                int nextRow = row + dRows[dir];
                int nextCol = col + dCols[dir];
                if (!InRange(nextRow, rows - 1) || !InRange(nextCol, cols - 1)) {
                    break;
                }
                row = nextRow;
                col = nextCol;
                sum += GetValue(row, col, rows);
                isVisited[row][col] = true;
            }
        }
        System.out.println(sum);
    }

    public static void main() {


        Solve();
    }
}


