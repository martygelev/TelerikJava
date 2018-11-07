using System;
using System.Linq;
namespace BusExcursion
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] busParameters = Console.ReadLine().Split(new char[] { ' ' },
                                                           StringSplitOptions.RemoveEmptyEntries)
                                         .Select(int.Parse).ToArray();

            int w = busParameters[0];
            int h = busParameters[1];
           
            int obstacle = int.Parse(Console.ReadLine());

            for (int i = 1; i <= obstacle; i++)
            {
                int[] paramArr = Console.ReadLine().Split(new char[] { ' ' },
                                                           StringSplitOptions.RemoveEmptyEntries)
                                         .Select(int.Parse).ToArray();

                int wParam = paramArr[0];
                int hParam = paramArr[1];

                if (w>wParam || h>hParam)
                {
                    Console.WriteLine(i);
                    return;
                }
            }

           
                Console.WriteLine("No crash");

        }
    }
}
