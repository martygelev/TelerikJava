using System;
using System.Linq;
using System.Numerics;

namespace Counting
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('"',StringSplitOptions.RemoveEmptyEntries).ToArray();

            BigInteger number = BigInteger.Parse(input[1]);

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(++number);
            }
        }
    }
}
