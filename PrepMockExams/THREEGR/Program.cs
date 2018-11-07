using System;
using System.Collections.Generic;
using System.Linq;
namespace THREEGR
{
    class Program
    {
        static void Main(string[] args)
        {


            string[] arr = Console.ReadLine().Split(new char[] { ' ' },
                                                    StringSplitOptions.RemoveEmptyEntries).ToArray();

            List<int> firstsGroup = new List<int>();
            List<int> secondsGroup = new List<int>();
            List<int> thirdsGroup = new List<int>();

            for (int i = 0; i < arr.Length; i++)
            {
                if (int.Parse(arr[i]) % 3 == 0)
                {
                    firstsGroup.Add(int.Parse(arr[i]));
                }
                else if (int.Parse(arr[i]) % 3 == 1)
                {
                    secondsGroup.Add(int.Parse(arr[i]));
                }
                else if (int.Parse(arr[i]) % 3 == 2)
                {
                    thirdsGroup.Add(int.Parse(arr[i]));
                }
            }
            foreach (int x in firstsGroup)
            {
                Console.Write(x + " ");
            }
            Console.WriteLine();
            foreach (int x in secondsGroup)
            {
                Console.Write(x + " ");
            }
            Console.WriteLine();
            foreach (int x in thirdsGroup)
            {
                Console.Write(x + " ");
            }
            Console.WriteLine();
        }
    }


}
