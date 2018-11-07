using System;
using System.Linq;
namespace GCD
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            int x = input[0];
            int y = input[1];
           int dev =GCD(x, y);

            x = x / dev;
            y = y / dev;

            Console.WriteLine(x+" "+y);
        }

        static int GCD(int a, int b)
        {
            int Remainder;

            while (b != 0)
            {
                Remainder = a % b;
                a = b;
                b = Remainder;
            }

            return a;
        }
    }
}
