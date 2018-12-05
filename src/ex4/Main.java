package ex4;

import java.util.*;

public class Main {

    // Not working as I want -> 35/100;
    static String[] input;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = Integer.parseInt(in.nextLine());

           input = in.nextLine().split(" ");

        long[][] matrix = new long[r][input.length];

        // input
        for (int k = 0; k < r; k++)
        {
            matrix[0][k]=Integer.parseInt(input[k]);
        }

        for (int k =1; k<r; k++)
        {
            input = in.nextLine().split(" ");
            for (int j =0; j<input.length;j++)
            {
                matrix[k][j]=Integer.parseInt(input[j]);
            }
        }

        // read last Line of c

        int[] coordinates = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Long> sums = new ArrayList<>();

        for (int i =0; i<coordinates.length;i+=2)
        {
            // positive input case
            int row = coordinates[i] ;
            int col = coordinates[i+1]  ;
            long sum =0;

            if (row>0 && col >0) {
                if (row==matrix[0].length-1 || row==0)
                {
                    if (row==0)
                        row=0;
                    else
                    row=matrix[0].length-1;
                }
                else {
                    row = coordinates[i] - 1;
                }

                if (col==matrix.length-1 || col ==0)
                {
                    if (col !=0)
                    col=matrix.length-1;
                    else col =0;
                }
                else{
                    col = coordinates[i + 1] - 1;

                }

                // sum row
                for (int q = 0; q < col; q++) {
                    sum += matrix[row][q];
                }

                // sum col
                for (int z = 1; z < row; z++) {
                    sum += matrix[z][col];
                }

            }
            else{
                if (row==0 || row >matrix.length-1) {
                   if( row == 0)
                       row =0;
                   else row =matrix.length-1;
                }
                else {
                    row = Math.abs(row) - 1;
                }
                if (col==0 || col >matrix[0].length-1) {
                    if( col == 0)
                        col =0;
                    else col =matrix[0].length-1;
                }
                else{
                col = Math.abs(col) -1;}

                //sum row

                for (int iqq = col; iqq < matrix[0].length; iqq++)
                {
                   sum+= matrix[row][iqq];
                }

                for (int uee = row+1; uee<matrix.length; uee++)
                {
                    sum+=matrix[uee][col];
                }
            }
            sums.add(sum);
        }

        Collections.sort(sums);
        Collections.reverse(sums);
        System.out.println(sums.get(0));
    }
}
