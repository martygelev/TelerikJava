using System;
using System.Linq;
namespace reverseArray
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(new char[]{' '}).Select(int.Parse).ToArray();

            int[] arr2 =  arr.Reverse().ToArray();

            Console.WriteLine(string.Join(", ",arr2));
        }
    }
}
