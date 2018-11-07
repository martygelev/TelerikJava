using System;

namespace random2
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            //firstLine 

            Console.WriteLine(new string('.',n)+new string('*',n));

            //middle

            for (int i = 1; i < n; i++)
            {
                Console.WriteLine(new string('.',n-i) + "*" + new string('.', n+i-2 )+ "*");
            }


            //bottom
            Console.WriteLine(new string('*',2*n));
        }
    }
}
