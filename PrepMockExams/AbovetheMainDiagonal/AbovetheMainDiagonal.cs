using System;

namespace AbovetheMainDiagonal
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            long[,] matrix = new long[number, number];

            double startRow = 0;
            double currentValue = 0;

            long sum = 0;

            matrix[0, 0] = 1;

            for (long i = 1; i <= number; i++)
            {
                startRow = i;

                if (i > 2)
                {
                    startRow = Math.Pow(2.0, (i - 1));
                }

                currentValue = startRow;

                //  Console.Write(startRow + " ");
                for (long z = 1; z <= number - 1; z++)
                {
                    //  Console.Write(currentValue*2 + " ");
                    matrix[i - 1, z - 1] = (long)currentValue;
                    currentValue = currentValue * 2;
                }
                matrix[i - 1, number - 1] = (long)currentValue;
                //  Console.WriteLine();
            }

            long rowLength = matrix.GetLength(0);
            long colLength = matrix.GetLength(1);

            for (long i = 0; i < rowLength; i++)
            {
                for (long j = 0; j < i; j++)
                {
                    sum += matrix[i, j];
                }
            }
            Console.WriteLine(sum);
        }
    }
}
