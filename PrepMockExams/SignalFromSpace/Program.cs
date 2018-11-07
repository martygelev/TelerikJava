using System;

namespace SignalFromSpace
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string rightMessage = ""+ input[0];

            for (int i = 1; i <input.Length; i++)
            {
                if (input[i]!=input[i-1])
                {
                    rightMessage += input[i];
                }

            }
            Console.WriteLine(rightMessage);
        }
    }
}
