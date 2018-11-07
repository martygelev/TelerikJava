using System;
using System.Linq;

namespace MergingandSquashing
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int[] inputArray = new int[number];

            for (int i = 0; i < number; i++)
            {
                inputArray[i] = int.Parse(Console.ReadLine());
            }

            int[] merging = new int[number - 1];
            int[] squashing = new int[number - 1];

            string temp = "";
            int currentNumber = 0;

            merging = Merging(inputArray, temp, currentNumber, number);
            squashing = Squashing(inputArray, number);

            foreach (var item in merging)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();

            foreach (var item in squashing)
            {
                Console.Write(item + " ");
            }

        }

         static int[] Squashing(int[] inputArray,int number)
          {
            int[] arr = new int[number - 1];

            for (int i = 0; i < inputArray.Length-1; i++)
            {
                int firstNumber = inputArray[i];
                int secondNumber = inputArray[i + 1];

                int fSecondDigit = firstNumber % 10;
                int sSecondDigit = secondNumber / 10;

                int middleDigit = fSecondDigit + sSecondDigit;

                if (middleDigit>9)
                {
                    middleDigit = middleDigit % 10;
                }

                string first = firstNumber.ToString();
                string second = secondNumber.ToString();

                string result = "";

                result = "" + first[0] + middleDigit.ToString() + second[1];

                int final = int.Parse(result);

                arr[i] = final;
            }

            return arr;
          }

        static int[] Merging(int[] inputArray, string temp,int currentNumber,int number)
       {
            int[] arr = new int[number-1];

            for (int i = 0; i < inputArray.Length - 1; i++)
            {
                temp = inputArray[i].ToString() + inputArray[i + 1].ToString();
                char[] str = temp.ToCharArray();
                string val = "";
                val = ""+ str[1] + str[2];
                currentNumber = int.Parse(val);
                arr[i] = currentNumber;
            }
            return arr;

        }
    }
}
