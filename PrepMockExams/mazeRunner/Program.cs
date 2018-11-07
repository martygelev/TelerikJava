using System;

namespace mazeRunner
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int evenSum = 0;
            int oddSum = 0;
            int digit;
            for (int i = 0; i < n; i++)
            {
                int numbers = int.Parse(Console.ReadLine());

                for (int z = 0; z < 4; z++)
                {
                    digit = numbers % 10;
                    numbers /= 10;

                    if (digit % 2 == 0)
                    {
                        evenSum += digit;
                    }
                    else
                    {
                        oddSum += digit;
                    }
                }

                if (evenSum == oddSum)
                {
                    Console.WriteLine("straight");
                }
                else if (evenSum > oddSum)
                {
                    Console.WriteLine("left");
                }
                else if (evenSum < oddSum)
                {
                    Console.WriteLine("right");
                }
                evenSum = 0;
                oddSum = 0;
            }
        }
    }
}
