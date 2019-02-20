import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheGreedyDward {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];
        int rowPos = 0;
        int colPos = 0;
        int coin = 0;
        for (int row = 0; row < size[0]; row++) {
            int[] line = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < size[1]; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 0) {
                    rowPos = row;
                    colPos = col;
                }
            }
        }
        int horRow = 0;
        int horCol = 0;

        while (true) {
            //left
            if (colPos > 0) {
                horCol = colPos - 1;
            }
            //right
            if (colPos < size[1] - 1) {

                if (!(colPos > 0)) {
                    horCol = colPos + 1;
                } else {
                    if (matrix[horRow][horCol] <= matrix[rowPos][colPos + 1]) {
                        horCol = colPos + 1;
                    }
                }
            }
            //up
            if (rowPos > 0) {
                if (matrix[horRow][horCol] < matrix[rowPos - 1][colPos]) {
                    horRow = rowPos - 1;
                    horCol = colPos;
                }
            }
            //down
            if (rowPos < size[0] - 1) {
                if (matrix[horRow][horCol] < matrix[rowPos + 1][colPos]) {
                    horRow = rowPos + 1;
                    horCol = colPos;
                }
            }
            if (matrix[horRow][horCol] != 0) {
                coin++;
                matrix[horRow][horCol] -= 1;
                rowPos = horRow;
                colPos = horCol;
            } else {
                coin++;
                System.out.println(coin);
                break;
            }
        }
    }
}
