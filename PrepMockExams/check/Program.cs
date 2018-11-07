using System;
using System.Linq;
using System.Numerics; 

namespace check
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToArray();

            var first = BigInteger.Parse(input[0]);
            var second = BigInteger.Parse(input[1]);

            var total = first - second;
            Console.WriteLine(total);
        } 
    }
}
