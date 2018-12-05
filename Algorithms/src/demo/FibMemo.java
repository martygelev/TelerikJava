package demo;
import java.util.ArrayList;
import java.util.List;

public class FibMemo
{
    private static List<String> direction;
    static int i;
    private static char[][] lab = {
    //      {' ', ' ', ' ', ' ', ' ', '*', ' '},
    //      {'*', '*', ' ', '*', ' ', ' ', ' '},
    //      {' ', ' ', ' ', '*', ' ', ' ', ' '},
    //      {' ', '*', '*', ' ', ' ', '*', ' '},
    //      {' ', ' ', ' ', ' ', '*', ' ', 'E'},
     {' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*','*',' ',' '},
     {' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ',' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ','*','*','*',' ','*',' ',' ',' ',' ',' ','*','*','*','*'},
     {' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' '},
     {' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ','е'},
    };

    static  int row;
    static int col;

    public static void main(String[] args)
    {
        row=0;
        col=0;
        findPath(0,0,"S");

    }
    public static void findPath(int row,int col,String dir)
    {
        if (!inRange(row, col))
        {
            return;
        }
        if (lab[row][col]=='E')
        {
            printLab();
            return;
        }
        if (lab[row][col]!=' ')
        {
         return;
        }

        lab[row][col]='V';
        findPath(row, col-1,"L"); // left
        findPath(row-1, col,"U"); // up
        findPath(row, col+1,"R"); // right
        findPath(row+1, col,"D"); // down
        //System.out.println(i++);
       lab[row][col]= ' ';
    }

    private static boolean inRange(int row, int col) {
       if (row>=0 && row <= lab.length-1&& col>=0 && col<=lab[0].length-1)
       {
           return true;
       }
       return false;
    }


    private static void printLab() {
        for (char[] chars : lab) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}


