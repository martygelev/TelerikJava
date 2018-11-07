using System;
using System.Collections.Generic;
using System.Linq;

namespace PathsinLabyrinth
{
    class Program 
    {
        static char[,] lab;
        static List<char> path = new List<char>();

        static void Main(string[] args)
        {
            ReadLab();
            Solve(0, 0,'S');
        }

        private static void Solve(int row, int col,char direction)
        {
            if (Outside(row,col))
            {
                return;
            }

            path.Add(direction);


            if (IsExit(row,col))
            {
                Print();
            }
            else if (IsPassable(row,col))
            {
                lab[row, col] = 'x';

                Solve(row - 1, col, 'U');
                Solve(row + 1, col, 'D');
                Solve(row , col - 1, 'L');
                Solve(row, col + 1, 'R');

                lab[row, col] = '-';

            }

            path.RemoveAt(path.Count -1);


        }

        private static bool Outside(int row, int col)
        {
            if (row<0 || row>=lab.GetLength(0) || col<0 || col>=lab.GetLength(1))
            {
                return true;
            }
            return false;
        }

        private static void Print()
        {
            Console.WriteLine(string.Join(string.Empty,path.Skip(1)));
        }

        private static bool IsPassable(int row, int col)
        {
            if (lab[row,col]=='x')
            {
                return false;
            }

            if (lab[row,col]=='*')
            {
                return false;
            }

            return true;
        }

        private static bool IsExit(int row, int col)
        {
            return lab[row, col] == 'e';
        }

        private static void ReadLab()
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());

            lab = new char[n, m];

            for (int i = 0; i < n; i++)
            {
                string currentRow = Console.ReadLine();

                for (int z = 0; z < m; z++)
                {
                    lab[i,z ] = currentRow[z];
                }
            }

        }
    }
}
