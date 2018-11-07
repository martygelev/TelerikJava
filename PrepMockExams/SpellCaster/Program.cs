using System;
using System.Linq;
using System.Text;

namespace SpellCaster
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(new char[] { ' ' },
                                                  StringSplitOptions.RemoveEmptyEntries).ToArray();
            StringBuilder firstStep = new StringBuilder();
            bool notEmpty = true;
           
            while (notEmpty)
            {
                notEmpty = false;
                for (int i = 0; i < arr.Length; i++)
                {
                    if (!(arr[i].Equals("")))
                    {
                        firstStep.Append(arr[i].Substring(arr[i].Length - 1, arr[i].Length));
                        arr[i] = arr[i].Substring(0, arr[i].Length - 1);
                        notEmpty = true;
                    }
                }
            }

            string aplhabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < firstStep.Length; i++)
            {
                int index = aplhabet.IndexOf(firstStep[i]);
                index += i + 1;
                while (index >= firstStep.Length)
                {
                    index -= firstStep.Length;
                }

                string character = firstStep.ToString().Substring(i, i + 1);
                firstStep = firstStep.Remove(i, 1);
                firstStep = firstStep.Insert(index, character);
            }
           Console.WriteLine(firstStep);

        }
    }
}
