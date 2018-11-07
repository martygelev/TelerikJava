using System;
namespace windows
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = 12345;
            double result = Math.Sqrt(number);
            Console.WriteLine($"{result:f2}");
        }
    }
}