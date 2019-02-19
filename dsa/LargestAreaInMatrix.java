package ok;

import java.util.*;

public class LargestAreaInMatrix {
    public static int[][] matrix;
    public static boolean[][] visited;
    public static int counter;
    public static int maxCounter;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray() ;
        int rows = data[0];
        int cols = data[1];

        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            int[] inputRow = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int z = 0; z<inputRow.length; z++){
                matrix[i][z] = inputRow[z];
            }
        }

         visited = new boolean[rows][cols];

        for (int row = 0; row<rows; row++){
            for (int col = 0; col<cols;col++){

                    countAll(row, col,matrix[row][col]);
                if (maxCounter <counter)
                {
                    maxCounter = counter;
                }
                counter = 0;
                }
            }
        System.out.println(maxCounter);
        }


    private static void countAll(int row, int col,int value) {
        if (row<0 || col<0 || row>matrix.length-1 || col>matrix[0].length-1){
            return;
        }
        if (visited[row][col]){
            return ;
        }
        if (matrix[row][col]!=value){
            return ;
        }
            counter++;
            visited[row][col] = true;
            countAll(row - 1, col, value);
            countAll(row + 1, col, value);
            countAll(row, col - 1, value);
            countAll(row, col + 1, value);
        }
}
