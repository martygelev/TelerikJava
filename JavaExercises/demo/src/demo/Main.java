package demo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int number = in.nextInt();
        int[][] matrix = new int[number][number];

        matrix[0][0]=1;
        int startValue =1;

        for (int  rows =0; rows <matrix.length; rows++)
        {
            matrix[rows][0] = startValue;
            startValue*=2;
            for (int cols =1; cols< matrix[rows].length; cols++)
            {
                matrix[rows][cols] = matrix[rows][cols-1]*2;
            }
        }

       for (int[] ints : matrix) {
           for (int anInt : ints) {
               System.out.print(anInt + " ");
           }
           System.out.println();
       }

        long sum = 0;





    }
}
