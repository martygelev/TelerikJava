using System;
using System.Collections.Generic;
using System.Linq;
namespace Parking
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            long[] arr1 = Console.ReadLine().Split(new char[] { ' ' },
                                                  StringSplitOptions.RemoveEmptyEntries)
                                .Select(long.Parse).Distinct().ToArray();
             int m = int.Parse(Console.ReadLine());
            long[] arr2 = Console.ReadLine().Split(new char[] { ' ' },
                                                  StringSplitOptions.RemoveEmptyEntries)
                                .Select(long.Parse).Distinct().ToArray();

            List<long> first = arr1.ToList();
            List<long> second = arr2.ToList();

            first.Sort();
            second.Sort();

            List<long> others = new List<long>();

            int counter = 0;
            for (int i = 0; i < first.Count; i++)
            {
                if(first.Contains(second[i]))
                {
                    counter++;
                }
                else
                {

                    others.Add(first[i]);
                }
            }

            if (counter==first.Count)
            {
                Console.WriteLine(counter);
            }
            else
            {
                foreach (var element in others)
                {
                    Console.Write(element+" ");
                }
                Console.WriteLine();
            }
        }
    }
}
