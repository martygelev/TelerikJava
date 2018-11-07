using System;
using System.Linq;
namespace windows
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split(new char[] { ' ' },
                                                   StringSplitOptions.RemoveEmptyEntries)
                                 .Select(int.Parse).ToArray();

            int numberOfBrokenWindows = input[0];
            int pricesm2 = input[1];

            int totalBroken = 0;
            for (int i = 0; i < numberOfBrokenWindows; i++)
            {
                int[] windowsParametres = Console.ReadLine().Split(new char[] { ' ' },
                                                   StringSplitOptions.RemoveEmptyEntries)
                                 .Select(int.Parse).ToArray();

                int h = windowsParametres[0];
                int w = windowsParametres[1];
                int broken = windowsParametres[2];

                if (broken==1)
                {
                    totalBroken += h * w;
                }
            }
            Console.WriteLine(totalBroken*pricesm2);
        }
    }
}
