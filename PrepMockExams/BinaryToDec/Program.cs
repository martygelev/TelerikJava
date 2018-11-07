using System;

namespace BinaryToDec
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            Console.WriteLine(Convert.ToInt32(input, 2).ToString());
        }
    }
}
