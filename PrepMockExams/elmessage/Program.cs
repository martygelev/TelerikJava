using System;
using System.Text.RegularExpressions;

namespace elmessage
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string pattern = @"[^\w\s\d.]+";

            RegexOptions options = RegexOptions.Multiline;
            int bestCounter = 0;
            foreach (Match m in Regex.Matches(input, pattern, options))
            {
                //Console.WriteLine("'{0}' found at index {1}.", m.Value, m.Index);

                if(m.Value.Length>bestCounter)
                {
                        bestCounter = m.Value.Length;
                }

            }
            Console.WriteLine(bestCounter);
        }
    }
}
