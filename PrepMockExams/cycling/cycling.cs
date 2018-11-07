using System;
using System.Linq;
namespace cycling
{
    class Program
    {
        static void Main(string[] args)
        {
            int inp = int.Parse(Console.ReadLine());
            int c;
            int m;
            int r;
            double maxs = 0;
            int mt = 0;
            int d=0;

            for (int i = 1; i <= inp; i++)
            {
                int[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

                c = input[0];
                m = input[1];
                r = input[2];
                mt = mt + 60 * c + m;
                double ms = (double)r / (60 * c + m);
                if (ms > maxs) {
                    maxs = ms;
                    d = i; 
                }
            }

            int d0 = mt / (24 * 60);
            mt = mt % (24 * 60);
            int c0 = mt / 60;
            mt = mt % 60;

            Console.WriteLine($"{d0} {c0} {mt} {d}");
        }
    }
}
