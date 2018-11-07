using System;
using System.Collections.Generic;

namespace paperCutter
{
    class Program
    {
        static void Main(string[] args)
        {
            int inputNumber = int.Parse(Console.ReadLine());

            int sheets = 1024;

            for (int i = 0; i <= 10; i++)
            {

                if (inputNumber - sheets >= 0)
                {
                    inputNumber -= sheets;

                }
                else
                {

                    Console.WriteLine("A" + i);
                }
                sheets /= 2;
            }
        }
    }
}
