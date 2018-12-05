package firstExam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] matrix;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input =  reader.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        int[][] matrix  =  new int[m][n];

        // readMatrix work
        for (int i =0; i<m; i++)
        {
            String[] matrixData = reader.readLine().split(" ");
            for (int j = 0; j < n; j++)
            {
             matrix[i][j] = Integer.parseInt(matrixData[j]);
            }
        }

        int startRow = 0;
        int startCol = 0;

        // find starting position work
        for (int i = 0; i<m; i++)
        {
            for(int j  = 0; j < n; j++)
            {
                if (matrix[i][j]==0)
                {
                    startCol=j;
                    startRow=i;
                }
            }
        }
        long sum =0;
        int left =0;
        int right =0;
        int up =0;
        int down =0;

        int currentRow = startRow;
        int currentCol =startCol;

       if (!(currentRow-1<0 || currentRow-1>m-1))
       {
           up = matrix[currentRow-1][currentCol];
       }
       if (!(currentRow+1<0 || currentRow+1>m-1))
       {
           down = matrix[currentRow+1][currentCol];
       }
       if (!(currentCol-1<0 || currentCol-1 >n-1))
       {
           left=matrix[currentRow][currentCol-1];
       }
       if (!(currentCol+1<0 || currentCol+1>n-1 ))
       {
           right=matrix[currentRow][currentCol+1];
       }
       // ^ sh*t
        while(true)
        {
            if (left<=0 && right<=0 && up <=0 && down<=0)
            {
                break;
            }

            if (left>=right && left>=up && left>=down)
            {
                currentCol-=1;

                if (matrix[currentRow][currentCol]>0)
                {
                    sum++;
                    matrix[currentRow][currentCol]--;
                }
                else {
                    currentCol += 1;
                }
            }
            else if (right>=left && right>=up && right>=down)
            {
                currentCol += 1;

                if (matrix[currentRow][currentCol]>0) {
                    sum++;
                    matrix[currentRow][currentCol]--;
                }
                else
                {currentCol -= 1;}

            }
            else if (up>=left && up>=right && up>=down)
            {
                currentRow-=1;

                if (matrix[currentRow][currentCol]>0)
                {
                    sum++;
                    matrix[currentRow][currentCol]--;
                }
                else {currentRow+=1;}


            }
           else  if (down>=left && down>=right && down>=up)
            {
                currentRow += 1;

                if (matrix[currentRow][currentCol]>0) {
                    sum++;
                    matrix[currentRow][currentCol]--;
                }
                else   {currentRow -= 1;}

            }
            //check If outside
            if (!(currentCol-1<0 || currentCol-1 >n-1))
            {
                left = matrix[currentRow][currentCol-1];

            }
            else {
                left=-1;
            }
            if (!(currentCol+1<0 || currentCol+1>n-1))
            {
                right = matrix[currentRow][currentCol+1];

            }
            else{right=-1;}
            if (!(currentRow-1<0 || currentRow-1>m-1))
            {
                up = matrix[currentRow-1][currentCol];

            }
            else{up=-1;}
            if(!(currentRow+1<0 || currentRow+1>m-1))
            {
                down = matrix[currentRow+1][currentCol];
            }
            else{down=-1;}

        }
        System.out.println(sum);
    }
}
