using System;

namespace BiggestPrimeNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());

            for (int i = input; i > 0; i--)
            {
                if (BiggestNumber(i))
                {
                    Console.WriteLine(i);
                    return;
                }

            }
        }

         static bool BiggestNumber(int number)
        {
            if (number == 1) return false;
            if (number == 2) return true;

            var limit = Math.Ceiling(Math.Sqrt(number)); //hoisting the loop limit

            for (int i = 2; i <= limit; ++i)
            {
                if (number % i == 0) return false;
            }

            return true;
        }
    }
}
