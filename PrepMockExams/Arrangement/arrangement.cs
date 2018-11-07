using System;
using System.Linq;
namespace Arrangement
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                               .Select(int.Parse).ToArray();

            bool ascending = true;
            bool descending = true;
            
            for (int i = 0; i < arr.Length-1; i++)
            {
                if (!(arr[i]<arr[i+1]))
                {
                    ascending = false;
                }
                else if (!(arr[i] > arr[i + 1]))
                {
                    descending = false;
                }
            }

            if (ascending)
            {
                Console.WriteLine("Ascending");
            }
            else if (descending)
            {
                Console.WriteLine("Descending");
            }
            else
            {
                Console.WriteLine("Mixed");
            }
        }
    }
}
