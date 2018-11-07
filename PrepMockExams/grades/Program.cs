using System;
using System.Collections.Generic;
using System.Linq;
namespace grades
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            List<int> grades = Console.ReadLine()
                                      .Split(new char[] { ' ' }, StringSplitOptions
                                             .RemoveEmptyEntries).Select(int.Parse).ToList();

            int max = grades.Max();
            int min = grades.Min();

            int sum = grades.Sum();

            int count = grades.Count() - 2;

            decimal total = sum - max - min;

        

            Console.WriteLine(Math.Round(total / count, 0, MidpointRounding.AwayFromZero));
        }
    }
}
