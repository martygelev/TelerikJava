using System;
using System.Collections.Generic;
using System.Linq;
namespace _2_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Dictionary<string, int> dictionaryUpper = new Dictionary<string, int>();
            Dictionary<string, int> dictionaryLower = new Dictionary<string, int>();

            for (char c = 'A'; c <= 'Z'; c++)
            {
                int key = c - 'A' + 1;
                dictionaryUpper.Add(c.ToString(), key);
            }

            for (char c = 'a'; c <= 'z'; c++)
            {
                int key = c - 'a' + 1;
                dictionaryLower.Add(c.ToString(), key);
            }
            long sum = 0;

            Dictionary<string, long> wordsValue = new Dictionary<string, long>();


            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();

                char[] words = input.ToCharArray();

                foreach (var item in words)
                {
                    if (dictionaryUpper.ContainsKey(item.ToString()))
                    {
                        sum += dictionaryUpper[item.ToString()];
                    }
                    if (dictionaryLower.ContainsKey(item.ToString()))
                    {
                        sum += dictionaryLower[item.ToString()];
                    }
                }

                if (wordsValue.ContainsKey(input))
                {
                    sum = 0;

                    continue;

                }
                wordsValue.Add(input, sum);
                sum = 0;
            }
            long maxValue = wordsValue.Values.Max();
            var myKey = wordsValue.FirstOrDefault(x => x.Value == maxValue).Key;

            Console.WriteLine(maxValue + " " + myKey);
        }
    }
}

// string[] input = Console.ReadLine().Split(new char[] { ' ' },StringSplitOptions.RemoveEmptyEntries).ToArray();

//int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();