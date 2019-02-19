import java.util.Scanner;

public class ticTacToe {
    static char[][] field;
    static char[][] solution;
    static char[] xOrO;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        solution = new char[3][ 3];
        field = new char[3][ 3];
        xOrO = new char[2];
        xOrO[0] = 'X';
        xOrO[1] = 'O';
        for (int i = 0; i < 3; i++)
        {
            String row = in.nextLine();

            for (int el = 0; el < row.length(); el++)
            {
                field[i][ el] = row.charAt(el);
            }
        }

        Solve(0, 0, 0, 0);
    }

    static void Solve(int col, int row, int current, int playerMove)
    {
        if (row == 3)
        {
            row = 0;
            col++;
        }

        if (col == 3)
        {
            return;
        }
        else
        {
            for (int i = 3 * col + row; i < 9; i++)
            {
                if (field[col][ row] != '-')
                {
                    solution[col][ row] = field[col][ row];
                }
                    else
                {
                    solution[col][ row] = xOrO[playerMove % 2];
                    playerMove++;
                    Solve(col, row, current, playerMove);
                }
            }
        }
    }
}
