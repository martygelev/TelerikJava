using System;
using System.Linq;

namespace mutating
{
    class Program
    {
        static void Main(string[] args)
        {
            int numbers = int.Parse(Console.ReadLine());

            int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            int[] changedArray = new int[numbers];

            for (int i = 0; i < numbers; i++)
            {
                 string num = input[i].ToString();
                string finalDigit = "";

                for (int z = 0; z <num.Length ; z++)
                {
                   char digit=  num[z];
                    int value = (int)Char.GetNumericValue(digit);
                    if (value == 0)
                    {
                        value = 9;
                    }
                    else if (value == 9)
                    {
                        value = 0;
                    }
                    else if (value%2==0)
                    {
                        value--;
                    }
                    else if (!(value%2==0))
                    {
                        value++;
                    }


                    string val = value.ToString();

                    finalDigit += val;
                }
                changedArray[i] =int.Parse(finalDigit);
            }

            int counter = 0;

           for (int i = 0; i < numbers; i++)
          {
                int currentFirst = input[i];
                int currentSecond = changedArray[i];

              int digit =   GCD(currentFirst, currentSecond);

                if (digit>0 && digit<=9)
                {
                    counter++;
                }
          }

            Console.WriteLine(counter);
        }

        static int GCD(int a, int b)
        {
            int Remainder;

            while (b != 0)
            {
                Remainder = a % b;
                a = b;
                b = Remainder;
            }

            return a;
        }
    }
}
