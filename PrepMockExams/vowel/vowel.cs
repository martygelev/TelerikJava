using System;
using System.Collections.Generic;

namespace vowel
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            // a, e, i, o, u, y

            List<string> word = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {
                word.Add(input[i].ToString());
            }

            int vowelsCounter = 0;
            int consonantsCounter = 0;

            List<string> vowels = new List<string>{ "a", "e", "i","o", "u","y" };

            for (int i = 0; i < word.Count; i++)
            {
                if (vowels.Contains(word[i]))
                {
                    vowelsCounter++;

                }
                else
                {
                    consonantsCounter++;
                }
            }

            if (vowelsCounter == consonantsCounter)
            {
                Console.WriteLine("Yes");
            }
            else{
                Console.WriteLine(vowelsCounter + " "+ consonantsCounter);
            }
        }
    }
}
