package exe_22_11.horsePath;
import java.util.Scanner;

public class Main {
    static int index = 1;

    static int wtf = -10;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[][] matrix = new int[num][num];

        Solve(matrix, 0, 0);
    }

    private static void Solve(int[][] matrix, int currentRow, int currentCol) {

        if (isFilled(matrix)) {
            PrintMatrix(matrix);
        }
        else {
            if (isPassable(matrix, currentRow, currentCol)) {
                Solve(matrix, currentRow - 2, currentCol - 1); // topLeft
                Solve(matrix, currentRow - 2, currentCol + 1); // topRight
                Solve(matrix, currentRow - 1, currentCol - 2); // leftUp
                Solve(matrix, currentRow + 1, currentCol - 2); // leftDown
                Solve(matrix, currentRow - 1, currentCol + 2); // rightUp
                Solve(matrix, currentRow + 2, currentCol - 1); // downLeft
                Solve(matrix, currentRow + 1, currentCol + 2); // rightDown
                Solve(matrix, currentRow + 2, currentCol + 1); // downRight
                Solve(matrix, 0, 0); // downRight
            }
        }

    }

    public static boolean isPassable(int[][] matrix, int currentRow, int currentCol) {
        if (Outside(matrix, currentRow, currentCol) == false) {
            if (isValidCell(matrix, currentRow, currentCol)) {
                matrix[currentCol][currentCol] = index;
                index++;
                wtf = index;
                return true;
            }
        }
        return false;
    }
    private static boolean isValidCell(int[][] matrix,int currentRow, int currentCol) {
       if (matrix[currentRow][currentCol]==0)
       {
           return  true;
       }
       return false;
    }

    private static void PrintMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isFilled(int[][] matrix) {
        if (wtf==index && matrix[0][0]==wtf)
        {
            return true;
        }
      return false;
    }

    private static boolean Outside(int[][] matrix,int currentRow, int currentCol)
    {
        if (currentRow<0 || currentRow>=matrix.length || currentCol<0 || currentCol>=matrix[currentRow].length)
        {
            return true;
        }
        return false;
    }
}
