using System;

namespace StokiLegs
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfLegs = int.Parse(Console.ReadLine());

            // chicken = 7;
            // bears = 2;
            // humans = 5;

            int combinationCounter = 0;

            for (int i = 0; i <= numberOfLegs / 7; i++)
            {
                for (int j = 0; j <= (numberOfLegs - 7 * i) / 5; j++)
                {
                    if ((numberOfLegs - 7 * i - j * 5) % 2 != 0)
                    {
                        if (i * 7 + j * 5 == numberOfLegs)
                        {
                            combinationCounter++;
                        }
                    }
                    else
                    {
                        combinationCounter++;
                    }
                }
            }

            Console.WriteLine(combinationCounter);
        }
    }
}