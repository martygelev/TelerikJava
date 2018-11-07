using System;
using System.Linq;
namespace MirrorPin
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(new char[] { ' ' },
                                                StringSplitOptions.RemoveEmptyEntries)
                              .ToArray();

            string first = Reverse(arr[0]);
            string sec = Reverse(arr[1]);

            int f = int.Parse(first);
            int s = int.Parse(sec);
		
            Console.WriteLine(Math.Max(f,s));
        }

        public static string Reverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}
