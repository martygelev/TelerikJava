using System;

namespace CombinationsWithoutRepetitions
{
    class Program
    {
        static void Main(string[] args)
        {
            int end = int.Parse(Console.ReadLine());
            int setItems = int.Parse(Console.ReadLine());

            int[] set = new int[setItems];

            int start = 1;
            int items = 0;


            Solve(set, start, end, items);
        }

        private static void Solve(int[] set, int start, int end, int items)
        {
            if (items == set.Length)
            {
                Console.WriteLine(string.Join(" ", set));
                return;
            }

            for (int i = start; i <= end; i++)
            {
                set[items] = i;
                Solve(set, i+1, end, items + 1);
                //          ^
                //          |
                //          without repetition
                // if we remove " + 1" it will print and rep val
            }
        }
    }
}

