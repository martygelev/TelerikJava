using System;
using System.Linq;

namespace icecream
{
    class Program
    {
        static void Main(string[] args)
        {

            long[] input = Console.ReadLine().Split(new char[] { ' ' },
                                                  StringSplitOptions.
                                                  RemoveEmptyEntries).
                                 Select(long.Parse).ToArray();

            long n = input[0];
            string number = input[1].ToString();
            long count = number.Length;

            if (n>count)
            {
                long diff = Math.Abs(n - count);
                Console.WriteLine(diff);

            }
            else
            {
                Console.WriteLine(0);
            }

        }
    }
}
