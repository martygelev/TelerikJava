using System;
using System.Text.RegularExpressions;

namespace digitsInText
{
    class Program
    {
        static void Main(string[] args)
        {

            string pattern = @"\d";
            string input = Console.ReadLine();
            RegexOptions options = RegexOptions.Multiline;

            int sum = 0;
            int counter = 0;
            foreach (Match m in Regex.Matches(input, pattern, options))
            {
                if (m.Success)
                {
                    sum += int.Parse(m.Value);
                    counter++;

                }

            }

            if (sum > 0 && counter > 0)
            {
                Console.WriteLine(sum);
            }

            else if (counter == 0)
            {
                Console.WriteLine("-1");

            }
            else
            {
                Console.WriteLine("0");
            }



        }
    }
}