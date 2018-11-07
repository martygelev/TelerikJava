using System;

namespace CrookedStairs
{
    class Program
    {
        static void Main(string[] args)
        {
            long firstNumber = long.Parse(Console.ReadLine());
            long secondNumber = long.Parse(Console.ReadLine());
            long thirdNumber = long.Parse(Console.ReadLine());
            long n = long.Parse(Console.ReadLine());


            Console.WriteLine(firstNumber);
            Console.WriteLine(secondNumber+ " "+thirdNumber);

            for (int i = 3; i < n+1; i++)
            {
                for (int z = 0; z < i; z++)
                {
                    long current = firstNumber + secondNumber + thirdNumber;
                    Console.Write(current + " ");
                    firstNumber = secondNumber;
                    secondNumber = thirdNumber;
                    thirdNumber = current;
                }
                Console.WriteLine();
             }
        }
    }
}
