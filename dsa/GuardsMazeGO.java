import java.util.Scanner;

public class GuardsMazeGO {
   static final int INFINITY = 1 << 30;
	static final int NORMAL_TIME = 1;
	static final int SLOW_TIME = 3;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        long[][] field = new long[rows][cols];

        int guards = Integer.parseInt(in.nextLine());
        for(int i = 0; i < guards; ++i)
        {
            line = in.nextLine().split(" ");
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);
            char dir = line[2].charAt(0);

            field[row][col] = INFINITY;
            switch(dir)
            {
                case 'U':
                    if(row > 0 && field[row - 1][col] == 0)
                {
                    field[row - 1][ col] = SLOW_TIME;
                }
                break;
                case 'D':
                    if(row < rows - 1 && field[row + 1][ col] == 0)
                {
                    field[row + 1][col] = SLOW_TIME;
                }
                break;
                case 'L':
                    if(col > 0 && field[row][col - 1] == 0)
                {
                    field[row][ col - 1] = SLOW_TIME;
                }
                break;
                case 'R':
                    if(col < cols - 1 && field[row][col + 1] == 0)
                {
                    field[row][ col + 1] = SLOW_TIME;
                }
                break;
            }
        }

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                if(field[i][ j] == 0)
                {
                    field[i][ j] = NORMAL_TIME;
                }

                if(i == 0 && j == 0)
                {
                    continue;
                }
                if(i == 0)
                {
                    field[i][j] += field[i][j - 1];
                }
                else if(j == 0)
                {
                    field[i][ j] += field[i - 1][j];
                }
                else
                {
                    field[i][ j] += Math.min(field[i][ j - 1], field[i - 1][j]);
                }
            }
        }

        long answer = field[rows - 1][ cols - 1];
        if(answer < INFINITY)
        {
            System.out.println(answer);
        }
        else
        {
            System.out.println("Meow");
        }

    }
}
/*
8 8
8
7 0 L
6 1 U
5 2 L
4 3 L
3 4 D
2 5 L
1 6 D
0 7 D
 */
