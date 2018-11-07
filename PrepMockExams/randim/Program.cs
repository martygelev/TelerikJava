using System;
using System.Linq;
using System.Numerics;

namespace randim
{
    class Program
    {
        static void Main(string[] args)
        {
            string inp = Console.ReadLine();
            string enter = "";
            if (inp.Contains('.'))
            {
                enter= inp.Replace(".","");
            }
            else
            {
                enter = inp;
            }

            BigInteger input = BigInteger.Parse(enter);
            input = BigInteger.Abs(input);

            BigInteger sum = 0;
            int lenght = input.ToString().Length;

            while (input>9)
            {
               // Console.WriteLine(lenght);
                for (int i = 0; i <lenght ; i++)
                {
                    
                    sum += input % 10;
                    input /= 10;
                }
                // Console.WriteLine(lenght);
                input = sum;
                sum = 0;
            }

            Console.WriteLine(input);

        }
    }
}
