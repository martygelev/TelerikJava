using System;
using System.Linq;
namespace ReverseArray
{
    class Program
    {
        static int[] inputArray;
        static void Main(string[] args)
        {
            inputArray = Console.ReadLine().Split(new char[]{' '},StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

            int index = 0;
            PrintReversedArray(inputArray,index);
        }

        private static void PrintReversedArray(int[] inputArray,int index)
        {
            int[] arr = new int[inputArray.Length];
            if (index==inputArray.Length)
            {
                return;
            }

            PrintReversedArray(inputArray, index + 1);
            Console.Write(inputArray[index] + " ");
        }
    }
}
