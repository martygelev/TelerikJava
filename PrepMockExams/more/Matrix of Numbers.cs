using System;

namespace more
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            for (int i = 1; i <=number; i++)
            {
                for (int z = i; z <i+number ; z++)
                {
                    Console.Write(z+ " ");
                }
                Console.WriteLine();
            }
        }
    }
}
