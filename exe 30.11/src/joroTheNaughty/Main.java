package joroTheNaughty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] inputData = in.nextLine().split(" ");
        int rows = Integer.parseInt(inputData[0]);
        int cols = Integer.parseInt(inputData[1]);
        int jumps = Integer.parseInt(inputData[2]);

        int[][] matrix = new int[rows][cols];
        int coutner = 1;

        for (int i =0; i<rows;i++)
        {
            for(int j =0; j<cols; j++)
            {
                matrix[i][j]=coutner;
                coutner++;
            }
        }

       String[] startingPositionInput =in.nextLine().split(" ");
        int currentRow = Integer.parseInt(startingPositionInput[0]);
        int currentCol = Integer.parseInt(startingPositionInput[1]);

        int sum =0;
        sum+=matrix[currentRow][currentCol];

        boolean[][] visitedCells = new boolean[rows][cols];
        visitedCells[currentRow][currentCol]=true;

        List<String> inputs = new ArrayList<>();

        for (int i =0 ; i<jumps; i++)
        {
            String nextPositionInput = in.nextLine();
            inputs.add(nextPositionInput);

            String[] nextPosition =nextPositionInput.split(" ");

            currentRow+=Integer.parseInt(nextPosition[0]);
            currentCol+=Integer.parseInt(nextPosition[1]);

            if (visitedCells[currentRow][currentCol]==true)
            {
                System.out.println("catchYouBitch");
                break;
            }
            if ( currentRow<0 || currentRow>rows-1 ||currentCol<0 || currentCol>cols-1)
            {
                System.out.println("escape bitch " + sum);
                break;
            }
            visitedCells[currentRow][currentCol]=true;
            sum += matrix[currentRow][currentCol];

        }
        int index =0;
        int length = inputs.size();

        while(true)
        {
            if (index>=length)
            {
                index=0;
            }

          String[] curInp=  inputs.get(index).split(" ");

            currentRow+=Integer.parseInt(curInp[0]);
            currentCol+=Integer.parseInt(curInp[1]);

            if ( currentRow<0 || currentRow>rows-1 ||currentCol<0 || currentCol>cols-1)
            {
                System.out.println("escaped " + sum);
                break;
            }

            if (visitedCells[currentRow][currentCol]==true)
            {
                System.out.println("catchYouBitch");
                break;
            }

            visitedCells[currentRow][currentCol]=true;
            sum += matrix[currentRow][currentCol];

            index++;
        }
    }
}
