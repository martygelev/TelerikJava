using System;
using System.Linq;
namespace Hops
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] inputArr = Console.ReadLine().Split(new char[] { ',', ' ' },
                                                      StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            int n = int.Parse(Console.ReadLine());
            int counter = inputArr[0];

            bool[] beenThere = new bool[inputArr.Length];

            beenThere[1] = true;

            int currentElement = inputArr[0];
            for (int i = 0; i < n; i++)
            {
                int[] direction = Console.ReadLine().Split(new char[] { ',', ' ' },
                                                           StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

                for (int z = 0; z < direction.Length; z++)
                {
                    int move = direction[0];
                    if (move>0)
                    {

                    }
                    else
                    {

                    }
                }
            }
        }
    }
}
