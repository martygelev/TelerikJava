using System;

namespace RecursiveFactorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int factorialNumber = int.Parse(Console.ReadLine());
            int result = 1;

            int sum = CalculateFactorial(factorialNumber,result);

            Console.WriteLine(sum);
        }

        private static int CalculateFactorial(int factorialNumber,int result)
        {
            int sum = 1;
            if (factorialNumber==result)
            {
                return 1;
            }
            else
            {
                sum = factorialNumber * CalculateFactorial(factorialNumber - 1, result);
                    return sum;
            }
        }
    }
}
