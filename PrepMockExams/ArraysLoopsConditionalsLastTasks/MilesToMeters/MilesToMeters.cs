using System;

namespace MilesToMeters
{
    class Program
    {
        static void Main(string[] args)
        {
            int miles = int.Parse(Console.ReadLine());

            Console.WriteLine(miles* 1609);
        }
    }
}
