import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class konq
{
    public static int[][] path;
    static  int index;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

         path = new int [length][length];
          int row =0;
          int col =0;
          index=1;
        path[row][col] = index;
        index++;

        while (true)
        {

            if (index-1==length*length)
            {
                break;
            }
           if(isUpLeft(row, col)){
               index++;
               col -=1;
               row -=2;
               continue;
           }
           else if (isUpRight(row,col))
           {
               index++;
               col +=1;
               row -=2;
               continue;
           }
           else if (isLeftUp(row,col))
           {
               index++;
              row -=1;
              col -=2;
               continue;
           }
           else if (isRightUp(row,col))
           {
               index++;
               row -=1;
               col +=2;
               continue;
           }
           else if (isLeftDown(row,col))
           {
               index++;
              row +=1;
                      col-=2;

               continue;
           }
           else if (isRightDown(row,col))
           {
               index++;
               row+=1;
               col +=2;
               continue;
           }
           else if (isDownLeft(row,col))
           {
               index++;
               row +=2;
               col -=1;
               continue;
           }


           else if (isDownRight(row,col))
           {
               index++;
              row+=2;
              col +=1;
               continue;
           }
           else {
               // check
               // TODO
               for (int i = 0; i <path.length ; i++) {
                   for (int j = 0; j <path[i].length ; j++) {
                       if (path[i][j]==0)
                       {
                           path[i][j]=index;
                           index++;
                           break;
                   }

               }
               }

           }
        }

        for (int[] ints : path) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
    private static boolean isDownRight(int row, int col) {
        int currentROW =  row +2;
        int currentCol = col+1;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }


    private static boolean  isDownLeft(int row, int col) {
        int currentROW =  row +2;
        int currentCol = col-1;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }
    private static boolean isRightDown(int row, int col) {
        int currentROW =  row +1;
        int currentCol = col+2;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }
    private static boolean isRightUp(int row, int col) {
        int currentROW =  row -1;
        int currentCol = col+2;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }

    private static boolean isLeftDown(int row, int col) {
        int currentROW =  row +1;
        int currentCol = col-2;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }
    private static boolean isLeftUp(int row, int col) {
        int currentROW =  row -1;
        int currentCol = col-2;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }

    private static boolean isUpRight(int row, int col) {
        int currentROW =  row -2;
        int currentCol = col+1;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return true;
        }
        return false;
    }

    private static boolean isUpLeft(int row, int col) {
        int currentROW =  row -2;
        int currentCol = col-1;

        if (isPassable(currentROW, currentCol))
        {
            path[currentROW][currentCol]=index;

            return  true;
        }
        return false;
    }

    private static boolean isPassable(int currentROW, int currentCol) {
   if (currentCol>= 0 && currentROW >=0 && currentROW<= path.length-1  && currentCol<=path[currentROW].length -1 && path[currentROW][currentCol]==0)
        {
            return true;
        }
        return  false;
    }
}
