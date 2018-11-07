using System;
using System.Linq;
namespace DigitsD
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split(new char[] { ' ' },
                                                   StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();


            int start = input[0];
            int end = input[1];
            int firstD = input[2];
            int secondD = input[3];

            int counter = 0;
            int current;
            int lastDigit;
            for (int i = start; i <=end; i++)
            {
                current = i;
                while (current != 0)
                {
                    lastDigit = current % 10;
                    if (lastDigit % firstD != 0 && lastDigit % secondD != 0)
                    { 
                        counter++;
                    }
                    current = current / 10;
                }
            }

            Console.WriteLine(counter);

        }
    }
}
