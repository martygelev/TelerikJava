package spiralMatrix;

import java.util.Scanner;

public class Main {
    static int counter ;
    public static void main(String[] args) {

        counter++;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] matrix = new int[n][n];
        int total = n*n;
        int currentRow =0;
        int currentCol=0;

        int currentLastRow=n-1;
        int currentLastCol = n-1;
        while (counter!=total+1 )
        {
            //firstRow
           for (int i =0; i<n; i++)
           {
               if (matrix[currentRow][i]==0){
                   matrix[currentRow][i]=counter;
                   counter++;
               }
           }

           //lastCol
            for (int i = 0; i<n; i++)
            {
                if (matrix[i][currentLastCol]==0)
                {
                    matrix[i][currentLastCol]=counter;
                    counter++;
                }
            }
            //lastRow rev
            for (int i = n-1; i>0 ; i--)
            {
                if (matrix[currentLastRow][i]==0)
                {
                    matrix[currentLastRow][i]=counter;
                    counter++;
                }
            }

            //firstCol rev
                     for (int i = n-1;i>0;i--)
                     {
                         if (matrix[i][currentCol]==0)
                         {
                             matrix[i][currentCol]=counter;
                             counter++;
                         }
                     }

                     currentCol++;
                     currentRow++;
                     currentLastRow--;
                     currentLastCol--;
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
