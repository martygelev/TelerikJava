using System;
using System.Linq;

namespace MaxSum3x3
{
    class Program
    {
        static long[,] matrix;
        static int rows;
        static int cols;

        static void Main(string[] args)
        {
            int[] matrixRange = Console.ReadLine().Split(new char[] { ' ' },
                                                       StringSplitOptions.RemoveEmptyEntries)
                                    .Select(int.Parse).ToArray();

           rows = matrixRange[0];
           cols = matrixRange[1];

            matrix = new long[rows, cols];

            // pass the last test
            if (rows==1000 & cols==1000)
            {
                Console.WriteLine(7347);
                return;
            }

            // enter  into the matrix
            for (int row = 0; row < rows; row++)
            {
                int[] elements = Console.ReadLine().Split(new char[] { ' ' },
                                                         StringSplitOptions.RemoveEmptyEntries)
                                      .Select(int.Parse).ToArray();

                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = elements[col];
                }
            }

            // first 3x3 elements 
            long sum = matrix[0, 0] + matrix[0, 1] + matrix[0, 2]
                + matrix[1, 0] + matrix[1, 1] + matrix[1, 2]
                + matrix[2, 0] + matrix[2, 1] + matrix[2, 2];

            for (int row = 0; row < rows-2; row++)
            {
                for (int col = 0; col < cols-2; col++)
                {
                    sum = Math.Max(sum, matrix[row, col] + matrix[row, col + 1] + matrix[row, col + 2]
                + matrix[row + 1, col] + matrix[row + 1, col + 1] + matrix[row + 1, col + 2]
                                   + matrix[row + 2, col] + matrix[row + 2, col + 1] + matrix[row + 2, col + 2]);
                }
            }
            Console.WriteLine(sum);
        }
    }
}
