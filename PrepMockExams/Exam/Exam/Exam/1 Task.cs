using System;
using System.Linq;
namespace Exam
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            //100
            char[] inputArray = input.ToCharArray();

            int x = 0;
            int y = 0;

            for (int i = 0; i < inputArray.Length; i++)
            {
                char symbol = inputArray[i];

                if (symbol=='L')
                {
                    x -= 1;
                }
                else if (symbol=='R')
                {
                    x += 1;
                }
                else if (symbol=='U')
                {
                    y += 1;
                }
                else if (symbol=='D')
                {
                    y -= 1;
                }
            }

            Console.WriteLine($"({x}, {y})");
        }
    }
}

// string[] input = Console.ReadLine().Split(new char[] { ' ' },StringSplitOptions.RemoveEmptyEntries).ToArray();

//int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();