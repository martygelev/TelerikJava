using System;
using System.Linq;
namespace Combinations
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] set = Console.ReadLine().Split(new char[]{' '},
                                                 StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            int number = int.Parse(Console.ReadLine());

            int[] vector = new int[number];
            int index = 0;
            int border = 0;

            GenerateCombination(set, vector, index, border);

        }

        private static void GenerateCombination(int[] set, int[] vector, int index, int border)
        {
            if (index==vector.Length)
            {
                Console.WriteLine(string.Join(" ",vector));
                return;
            }

            for (int i = border; i < set.Length; i++)
            {
                vector[index] = set[i];

                GenerateCombination(set, vector, index+1, i+1);


            }
        }
    }
}

