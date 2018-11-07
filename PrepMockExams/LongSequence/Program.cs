using System;

namespace LongSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[1000];

            arr[0] = 2;
            arr[1] = -3;

            for (int i = 2; i < arr.Length; i++)
            {

                if (i%2==0)
                {
                    int prev = arr[i - 2];

                    arr[i] = prev + 2;
                }
                else if (i%2==1)
                {
                    int prev = arr[i - 2];

                    arr[i] = prev - 2;
                }

            }

            foreach (var item in arr)
            {
                Console.WriteLine(item);
            }


        }
    }
}
