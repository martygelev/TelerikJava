using System;
using System.Linq;
using System.Numerics;

namespace bitShift
{
    class Program
    {
        static int rows;
        static int cols;
        static int[] steps;
        static BigInteger[,] matrix;
        static void Main(string[] args)
        {
            rows = int.Parse(Console.ReadLine());
            cols = int.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());
            steps = Console.ReadLine().Split(new char[]{' '},StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
            matrix = new BigInteger[rows, cols];


            fillMatrix();

            BigInteger sum = 0;
            int[] position = { rows - 1, 0 };
            int coef = rows>cols ?rows : cols;
            sum += matrix[position[0], position[1]];
            matrix[position[0], position[1]] = 0;

            foreach (int step in steps)
            {
                int[] target = { step / coef, step % coef };

                int rowStep = Math.Sign(target[0] - position[0]);
                int colStep = Math.Sign(target[1] - position[1]);

                do
                {
                    position[1] += colStep;
                    sum += matrix[position[0], position[1]];
                    matrix[position[0], position[1]] = 0;
                }
                while (position[1] != target[1] && position[1] >= 0 && position[1] < cols);

                do
                {
                    position[0] += rowStep;
                    sum += matrix[position[0], position[1]];
                    matrix[position[0], position[1]] = 0;
                }
                while (position[0] != target[0] && position[0] >= 0 && position[0] < cols);

            }
            Console.WriteLine(sum);


        }
        private static  void fillMatrix()
        {
            for (int i = 0; i < rows; i++)  
            {
                for (int j = 0; j < cols; j++)
                {
                    matrix[i, j] = (BigInteger)(1) << (rows - 1 - i + j);
                }
            }
        }
    }
}
