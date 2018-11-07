using System;

namespace Generating0_1Vectors
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] vector = new int[n];

            int position = 0;
            GenerateVector(position, vector);
        
        }

        private static void GenerateVector(int positon, int[] vector)
        {
            if (positon==vector.Length)
            {
                Console.WriteLine(String.Join("", vector));
                return;

            }

            for (int i = 0; i <= 1; i++)
            {
                vector[positon] = i;
                GenerateVector(positon + 1, vector);

            }
        }
    }
}
