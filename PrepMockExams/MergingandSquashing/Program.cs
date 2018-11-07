using System;
using System.Linq;

namespace MergingandSquashing
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int[] inputArray = new int[number];

            for (int i = 0; i < number; i++)
            {
                inputArray[i] = int.Parse(Console.ReadLine());
            }

            int[] merging = new int[number - 1];
            int[] squashing = new int[number - 1];

            for (int i = 0; i < number; i++)
            {//wrong
                
                string merge = inputArray[i].ToString() + inputArray[i + 1].ToString();

                string result = merge.Skip(1).ToString();
                result = result.Take(2).ToString();

                merging[i] = int.Parse(result);
            }

            Console.WriteLine(string.Join(" ",merging));
        }
    }
}
