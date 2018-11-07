using System;

namespace CombinationsWithRep
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Print(n);
        }

        private static void Print(int n)
        {

            if (n<=0)
            {
                return ;
            }

            Console.WriteLine(new string('*',n));
            Print(n - 1);
            Console.WriteLine(new string('#',n));
        }
    }
}
