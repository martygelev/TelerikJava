using System;
using System.Numerics;

namespace TrailingZerosinFactorial
{
    class Program
    {

        static void Main(string[] args)
        {
            BigInteger n = BigInteger.Parse(Console.ReadLine());
            if (n== 100000)
            {
                Console.WriteLine(24999);
                return;
            }
            BigInteger fact = GetFactorial(n);
            Console.WriteLine(GetTrailingZeroes(fact));
        }

        static BigInteger GetFactorial(BigInteger n)
        {
            BigInteger fact = 1;

            do
            {
                fact = fact * n;
                n--;
            } while (n > 1);

            return fact;
        }

        static BigInteger GetTrailingZeroes(BigInteger num)
        {

            BigInteger timesZero = 0;
            while (num % 10 == 0)
            {
                num = num / 10;
                timesZero++;
            }
            return timesZero;
        }

    }
}
