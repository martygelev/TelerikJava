using System;
using System.Linq;
using System.Numerics;

namespace bshm2
{
    class Program
    {
        static void Main(string[] args)
        {
            int rowsCount = int.Parse(Console.ReadLine());
            int colsCount = int.Parse(Console.ReadLine());

            var n = Console.ReadLine();

            bool[,] collected = new bool[rowsCount, colsCount];

            int[] moves = Console.ReadLine()
                                    .Split(' ')
                                    .Select(int.Parse)
                                    .ToArray();

            BigInteger sum = 0;
            int row = rowsCount - 1;
            int col = 0;
            BigInteger currentCellValue = 1;
            int coeff = Math.Max(rowsCount, colsCount);

            foreach (var move in moves)
            {
                int nextRow = move / coeff;
                int nextCol = move % coeff;
                int deltaCol = nextCol < col ? -1 : 1;

                while (col != nextCol)
                {
                    if (!collected[row, col])
                    {
                        sum += currentCellValue;
                        collected[row, col] = true;
                    }

                    if (deltaCol == 1)
                    {
                        currentCellValue *= 2;
                    }
                    else
                    {
                        currentCellValue /= 2;
                    }

                    col += deltaCol;
                }

                var deltaRow = nextRow < row ? -1 : 1;

                while (row != nextRow)
                {
                    if (!collected[row, col])
                    {
                        sum += currentCellValue;
                        collected[row, col] = true;
                    }

                    if (deltaRow == 1)
                    {
                        currentCellValue /= 2;
                    }
                    else
                    {
                        currentCellValue *= 2;
                    }

                    row += deltaRow;
                }
            }

            if (!collected[row, col])
            {
                sum += currentCellValue;
                collected[row, col] = true;
            }

            Console.WriteLine(sum);
        }
    }
}
