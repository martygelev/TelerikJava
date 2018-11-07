using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace password
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string year = "" + input[6] + input[7] + input[8] + input[9];

            int born = int.Parse(year);

            int now = 2018;

            Console.WriteLine(now-born);
            Console.WriteLine(2028-born);
        }

    }
}
