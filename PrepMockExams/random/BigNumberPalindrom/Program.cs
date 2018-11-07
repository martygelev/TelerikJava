using System;
using System.Collections.Generic;

namespace BigNumberPalindrom
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string input = "";
            for (int i = 0; i < n; i++)
            {
             string input2 = Console.ReadLine();

                input +=  "" + input2;
            }

            HashSet<int> pali = new HashSet<int>();
            for (int i = 0; i < input.Length; i++)
            {
                for (int z = 1; z < input.Length; z++)
                {
                    string temp = ""+ input[i] + input[z];
                    if (IsPalindrome(temp))
                    {
                        pali.Add(int.Parse(temp));
                    }
                }
            }

            for (int i = input.Length; i>0; i--)
            {
                for (int z = input.Length-1; z >0; z--)
                {
                    string temp = "" + input[i] + input[z];

                    if (IsPalindrome(temp))
                    {
                        pali.Add(int.Parse(temp));
                    }
                }
            }
        }

   public static bool IsPalindrome(string value)
    {
        int min = 0;
        int max = value.Length - 1;
        while (true)
        {
            if (min > max)
            {
                return true;
            }
            char a = value[min];
            char b = value[max];
            if (char.ToLower(a) != char.ToLower(b))
            {
                return false;
            }
            min++;
            max--;
        }
    }
    }
}
