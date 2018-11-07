using System;

namespace NumbersTriangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            // to N
            for (int i = 1; i <=n; i++)
            {
                for (int z = 1; z <=i; z++)
                {
                    Console.Write(z+ " ");
                }
                Console.WriteLine();
            }

            // to 1

            for (int i = n-1; i >=1; i--)
            {
                for (int s = 1; s <= i; s++)
                {
                    Console.Write(s+ " ");
                }
                Console.WriteLine();
            }
        }
    }
}
