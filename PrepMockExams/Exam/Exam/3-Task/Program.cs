using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace _3_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            //100
            string input = Console.ReadLine();

            string patternField = @"^[a-z]+$";
            string patternConstant = @"^[A-Z]+$";
            string patternPascal = @"^[A-Z]{1}[a-z]+$";
            string elephant = @"^[a-z]+[A-Z]+$";

            foreach (Match m in Regex.Matches(input, patternField))
            {
                Console.WriteLine("field");
                return;
            }

            foreach (Match m in Regex.Matches(input, patternConstant))
            {
                Console.WriteLine("constant");
                return;
            }
            foreach (Match m in Regex.Matches(input, patternPascal))
            {
                Console.WriteLine("pascal");
                return;
            }
            foreach (Match m in Regex.Matches(input, elephant))
            {
                Console.WriteLine("elephant");
                return;
            }
        
           Console.WriteLine("mismatch");
        }
    }
}

// string[] input = Console.ReadLine().Split(new char[] { ' ' },StringSplitOptions.RemoveEmptyEntries).ToArray();

//int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();