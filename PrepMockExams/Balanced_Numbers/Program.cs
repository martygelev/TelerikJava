using System;

namespace Balanced_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int sum = 0;
            int num = int.Parse(Console.ReadLine());

            while (true)
            {
                int temp = num;

                    int first = num % 10;
                    num /= 10;
                    int second = num % 10;
                    int third = num / 10;

                    if (first+third==second)
                    {
                        sum += temp;
                    }

                    else{
                        Console.WriteLine(sum);
                        return;
                    }
             num = int.Parse(Console.ReadLine());

            }
        }
    }
}
