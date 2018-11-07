using System;
using System.Collections.Generic;
using System.Linq;

namespace ArraySearch
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> listInput = Console.ReadLine().
                                         Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                                         .Select(int.Parse).ToList();

            int length = listInput.Count;

            List<int> notThere = new List<int>();
            for (int i = 1; i <= length; i++)
            {
                bool contains = false;
                 contains = NewMethod(listInput, i);

                if (contains)
                {
                    notThere.Add(i);
                }
            }

            notThere.Sort();

            Console.WriteLine(string.Join(",",notThere));

        }

        private static bool NewMethod(List<int> listInput, int i)
        {
            if (!(listInput.Contains(i)))
            {
                return true;
            }
            return false;
        }
    }
}
