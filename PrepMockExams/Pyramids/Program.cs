using System;

namespace Pyramids
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int counter = 0;

            for (int i = 1; i <=number; i++)
            {
                for (int z = 1; z <= i; z++)
                {
                    Console.Write(new string('o',i));
                }
                Console.WriteLine();
            }

        }
    }
}
