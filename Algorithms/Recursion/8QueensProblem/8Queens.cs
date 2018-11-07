using System;
using System.Collections.Generic;

namespace _8QueensProblem
{
    class Program
    {
        const int Size = 10;
        static int[,] board = new int[Size, Size];
        static HashSet<int> attackedRows = new HashSet<int>();
        static HashSet<int> attackedCols= new HashSet<int>();

        static void Main(string[] args)
        {
            Solve(0);
        }

        private static void Solve(int row)
        {
            if (row == Size)
            {
                PrintBoard();
            }

            for (int col = 0; col < Size; col++)
            {
                if (CanPutQueenThere(row,col))
                {
                    MarkAttacked(row,col);
                    Solve(row + 1);
                    UnmarkAttacked(row,col);
                }
            }
        }

        private static void UnmarkAttacked(int row ,int col)
        {
            board[row, col] = 0;
            attackedRows.Remove(row);
            attackedCols.Remove(col);
        }

        private static void MarkAttacked(int row,int col)
        {
            board[row, col] = 1;
            attackedRows.Add(row);
            attackedCols.Add(col);
        }

        private static bool CanPutQueenThere(int row ,int col)
        {
            if (attackedRows.Contains(row))
            {
                return false;
            }

            if (attackedCols.Contains(col))
            {
                return false;
            }

            if (DiagonalCheck(row,col)==false)
            {
                return false;
            }

            return true;
        }

        private static bool DiagonalCheck(int row, int col)
        {
            for (int i = 0; i < Size; i++)
            {
                int currentRow = row - i;
                int currentCol = col - i;

                if (currentRow<0 || currentCol<0 || currentRow>=Size || currentCol>=Size)
                {
                    break;
                }

                if (board[currentRow,currentCol]==1)
                {
                    return false;
                }
            }

            for (int i = 0; i < Size; i++)
            {
                int currentRow = row - i;
                int currentCol = col + i;

                if (currentRow < 0 || currentCol < 0 || currentRow >= Size || currentCol >= Size)
                {
                    break;
                }

                if (board[currentRow, currentCol] == 1)
                {
                    return false;
                }
            }
            for (int i = 0; i < Size; i++)
            {
                int currentRow = row + i;
                int currentCol = col - i;

                if (currentRow < 0 || currentCol < 0 || currentRow >= Size || currentCol >= Size)
                {
                    break;
                }

                if (board[currentRow, currentCol] == 1)
                {
                    return false;
                }
            }
            for (int i = 0; i < Size; i++)
            {
                int currentRow = row + i;
                int currentCol = col + i;

                if (currentRow < 0 || currentCol < 0 || currentRow >= Size || currentCol >= Size)
                {
                    break;
                }

                if (board[currentRow, currentCol] == 1)
                {
                    return false;
                }
            }

            return true;
        }

        private static void PrintBoard()
        {
            for (int rows = 0; rows < Size; rows++)
            {
                for (int cols = 0; cols < Size; cols++)
                {


                    if (board[rows,cols]==1)
                    {
                        Console.Write("Q ");
                    }
                    else
                    {
                        Console.Write("- ");
                    }
                }
                Console.WriteLine();
            }
            Console.WriteLine("**********************");
        }
    }
}
 
