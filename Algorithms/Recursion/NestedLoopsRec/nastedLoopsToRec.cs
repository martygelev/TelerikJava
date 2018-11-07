using System;

namespace NestedLoopsRec
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int currentValue = 0;
            int[] vector = new int[number];

            Solve(number,currentValue,vector);
        }

        private static void Solve(int number,int currentValue,int[] vector)
        {
            if (currentValue==number)
            {
                Console.WriteLine(string.Join(" ",vector));
                return;
            }

            for (int i = 1; i <= number; i++)
            {
                vector[currentValue] = i;
                Solve(number, currentValue+1, vector);
            }

        }
    }
}
