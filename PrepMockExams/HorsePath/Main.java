
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] matrix = new int[n][n];
        int index = 1;
        int row = 0;
        int col = 0;
        matrix[row][col] = index;
        index++;
        boolean isFill = true;
        while(isFill) {
            //up-left
            if(row - 2 >= 0 && col - 1 >= 0 && matrix[row - 2][col - 1] == 0) {

                matrix[row - 2][col - 1] = index;
                index++;
                row -= 2;
                col -= 1;

                //up-right
            } else if(row - 2 >= 0 && col + 1 < matrix.length && matrix[row - 2][col + 1] == 0) {

                matrix[row - 2][col + 1] = index;
                index++;
                row -= 2;
                col += 1;

                //left-up
            } else if(row - 1 >= 0 && col - 2 >= 0 && matrix[row - 1][col - 2] == 0) {

                matrix[row - 1][col - 2] = index;
                index++;
                row -= 1;
                col -= 2;

                //right-up
            } else if(row - 1 >= 0 && col + 2 < matrix.length && matrix[row - 1][col + 2] == 0) {

                matrix[row - 1][col + 2] = index;
                index++;
                row -= 1;
                col += 2;
                //left-down
            } else if(row + 1 < matrix.length && col - 2 >= 0 && matrix[row + 1][col - 2] == 0) {

                matrix[row + 1][col - 2] = index;
                index++;
                row += 1;
                col -= 2;
                //right-down
            } else if(row + 1 < matrix.length && col + 2 < matrix.length && matrix[row + 1][col + 2] == 0) {

                matrix[row + 1][col + 2] = index;
                index++;
                row += 1;
                col += 2;
                //down-left
            } else if(row + 2 < matrix.length && col - 1 >= 0 && matrix[row + 2][col - 1] == 0) {

                matrix[row + 2][col - 1] = index;
                index++;
                row += 2;
                col -= 1;

            } else if(row + 2 < matrix.length && col + 1 < matrix.length && matrix[row + 2][col + 1] == 0) {
                //down-right
                matrix[row + 2][col + 1] = index;
                index++;
                row += 2;
                col += 1;

            } else {
                for(int i = 0; i < matrix.length; i++) {
                    for(int j = 0; j < matrix.length; j++) {
                        if(matrix[i][j] == 0) {
                            matrix[i][j] = index;
                            index++;
                            row = i;
                            col = j;
                            isFill = true;
                            i = matrix.length;
                            j = matrix.length;
                        } else {
                            isFill = false;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}