using System;
using System.Linq;

namespace JoroTheRabit
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inputNumbers = Console.ReadLine()
                                        .Split(new char[] {' ',','}
                                        ,StringSplitOptions
                                        .RemoveEmptyEntries)
                                        .Select(int.Parse)
                                        .ToArray();

            int jumps = 0;

            for (int startPoint = 0; startPoint < inputNumbers.Length; startPoint++)
            {
                for (int step = 1; step < inputNumbers.Length; step++)
                {
                    int index = startPoint;
                    int length = 1;
                    int nextJump = (index + step) % inputNumbers.Length;

                    while (inputNumbers[index]<inputNumbers[nextJump] && nextJump != startPoint)
                    {
                        length++;
                        index = nextJump;
                        nextJump = (index + step) % inputNumbers.Length;

                       
                    }

                    if (length > jumps)
                        jumps = length;
                }
            }

            Console.WriteLine(jumps);



        }
    }
}
