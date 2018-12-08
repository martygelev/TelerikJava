package bounce3;

import java.util.Scanner;

public class Main {
    static long[][] matrix;
    static int rowsLength;
    static int colsLength;
    static long sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        rowsLength = in.nextInt();
        colsLength = in.nextInt();
        if (rowsLength==1 &&( colsLength==1 || colsLength==2))
        {
            System.out.println(1);
            return;
        }
       if (rowsLength==2 && colsLength==1)
       {
           System.out.println(1);
           return;
       }
        matrix = new long[rowsLength][colsLength];
        sum = 0;
        int currentRow = 0;
        int currentPositionCol = 0;
        matrix[currentRow][currentPositionCol] = 1;

        long value = 1;

        // first row
        for (int i = 1; i < matrix[0].length; i++) {
            value *= 2;
            matrix[0][i] = value;
        }
        // first col
        value = 1;
        for (int i = 1; i < matrix.length; i++) {
            value *= 2;
            matrix[i][0] = value;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {

                matrix[i][j] = matrix[i][j - 1] * 2;
            }
        }
    //    for (int[] ints : matrix) {
    //        for (int anInt : ints) {
    //            System.out.print(anInt + " ");
    //        }
    //        System.out.println();
    //    }
        sum +=matrix[currentRow][currentPositionCol]; // FIRST CELL
        currentRow+=1;
        currentPositionCol+=1;
       sum+= matrix[currentRow][currentPositionCol]; // [1;1] cell


        // check on If statement if you can add the next cell and compare it to border cells

       //example
        //if( currentRow -1 <0 || currentRow -1 >rowLength -1 ...)

     //   System.out.println(sum);

        while(!((currentRow==0 && currentPositionCol==0) || (currentRow==0 && currentPositionCol==colsLength-1)
        ||(currentRow==rowsLength-1 && currentPositionCol==0 )||( currentRow==rowsLength-1 && currentPositionCol == colsLength-1)))
        {
            while(!((currentRow==0 && currentPositionCol==0) || (currentRow==0 && currentPositionCol==colsLength-1)
                    ||(currentRow==rowsLength-1 && currentPositionCol==0 )||( currentRow==rowsLength-1 && currentPositionCol == colsLength-1)))
            {
                if (currentRow+1<=rowsLength-1 && currentRow+1 >=0 && currentPositionCol+1 <= colsLength-1 && currentPositionCol+1>=0)
                {
                    //down right
                    currentRow+=1;
                    currentPositionCol+=1;
                    sum+=matrix[currentRow][currentPositionCol];
                    //System.out.println(sum);

                }
                else{
                    break;
                }
            }
            while(!((currentRow==0 && currentPositionCol==0) || (currentRow==0 && currentPositionCol==colsLength-1)
                    ||(currentRow==rowsLength-1 && currentPositionCol==0 )||( currentRow==rowsLength-1 && currentPositionCol == colsLength-1)))
            {
                if (currentRow-1<=rowsLength-1 && currentRow-1 >=0 && currentPositionCol+1 <= colsLength-1 && currentPositionCol+1>=0)
                {
                    //  UpRight
                    currentRow-=1;
                    currentPositionCol+=1;
                    sum+=matrix[currentRow][currentPositionCol];
                 //  System.out.println(sum);

                }
                else {
                    break;
                }
            }


            while(!((currentRow==0 && currentPositionCol==0) || (currentRow==0 && currentPositionCol==colsLength-1)
                    ||(currentRow==rowsLength-1 && currentPositionCol==0 )||( currentRow==rowsLength-1 && currentPositionCol == colsLength-1)))
            {
                if (currentRow-1<=rowsLength-1 && currentRow-1 >=0 && currentPositionCol-1 <= colsLength-1 && currentPositionCol-1>=0)
                {
                    //UpLeft
                    currentRow-=1;
                    currentPositionCol-=1;
                    sum+=matrix[currentRow][currentPositionCol];
                 //  System.out.println(sum);

                }
                else{
                    break;
                }
            }
            while(!((currentRow==0 && currentPositionCol==0) || (currentRow==0 && currentPositionCol==colsLength-1)
                    ||(currentRow==rowsLength-1 && currentPositionCol==0 )||( currentRow==rowsLength-1 && currentPositionCol == colsLength-1)))
            {
                if (currentRow+1<=rowsLength-1 && currentRow+1 >=0 && currentPositionCol-1 <= colsLength-1 && currentPositionCol-1>=0)
                {
                    //downLeft
                    currentRow+=1;
                    currentPositionCol-=1;
                    sum+=matrix[currentRow][currentPositionCol];
                  //  System.out.println(sum);

                }
                else {
                    break;
                }
            }
        }
        System.out.println(sum);

    }
}

