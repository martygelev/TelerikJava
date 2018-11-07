using System;
using System.Collections.Generic;
using System.Linq;
namespace NextPermutation
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<int> listInput = Console.ReadLine().Split(new char[] { ' ' },
                                                           StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();

            int lastElement = listInput[n-1];
            int before = listInput[n - 2];

            listInput[n - 1] = before;
            listInput[n - 2] = lastElement;

            foreach (var item in listInput)
            {
                Console.Write(item + " ");
            }

        }
    }
}
