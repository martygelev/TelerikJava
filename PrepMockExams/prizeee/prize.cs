using System;
using System.Collections.Generic;
using System.Linq;
namespace prizeee
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> grades = Console.ReadLine().Split(new char[] { ',', ' ' },
                                                        StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();
            int counte = 0;
            if (grades.Contains(2))
            {
                Console.WriteLine("No");
                return;
            }
            else 
            {
                foreach (var item in grades)
                {
                    if (item ==6)
                    {
                        counte++;
                    }
                }
            }

            if (counte==0)
            {
                Console.WriteLine("No");
                return;
            }

            Console.WriteLine(new string('*',counte));
        }
    }
}
