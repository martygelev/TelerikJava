using System;

namespace Prime_Triangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (long i = 1; i <n; i++)
            {
                if (!isPrime(i))
                {
                    for (long z = 1; z <= i; z++)
                    {
                        if (isPrime(z))
                        {
                            Console.Write(0);
                        }
                        else
                        {
                            Console.Write(1);
                        }
                    }
                    Console.WriteLine();
                }
            }

        }

        public static bool isPrime(long number)
        {

            if (number == 1) return false;
            if (number == 2) return false;

            var limit = Math.Sqrt(number); //hoisting the loop limit

            for (int i = 2; i <= limit; ++i)
            {
                if (number % i == 0)
                {
                    return true;
                }

            }
            return false;

        }

           

        }
}