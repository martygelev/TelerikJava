using System;

namespace DecimalToHex
{
    class Program
    {
        static void Main(string[] args)
        {
            string hexValue = Console.ReadLine();
            Console.WriteLine(Convert.ToInt64(hexValue, 16));
        }
    }
}
