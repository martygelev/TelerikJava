using System;
using System.Text.RegularExpressions;

namespace maxEven
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\d+";
            string input = Console.ReadLine();
            RegexOptions options = RegexOptions.Multiline;
            int max = -1;

            foreach (Match m in Regex.Matches(input, pattern, options))
            {
                int number = int.Parse(m.Value);
                if (number%2==0 && number>max)
                {
                    max = number;
                }
            }

            Console.WriteLine(max);

        }
    }
}
