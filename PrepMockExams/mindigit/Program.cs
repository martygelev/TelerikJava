using System;

namespace mindigit
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int min = int.MaxValue;

            for (int i = 0; i < 4; i++)
            {
                int current = number % 10;
                number /= 10;

                if (current<min && current !=0)
                {
                    min = current;
                }

            }

            Console.WriteLine(min);
        }
    }
}
