using System;

namespace sms
{
    class Program
    {
        static void Main(string[] args)
        {
            string sms = Console.ReadLine();

            string cript = "";

             string changed  = sms.Substring(0, 1);
            cript = changed;

            int i = 1;

            while (i<sms.Length)
            {
                cript = changed + sms[i] + changed;
                changed = cript;
                i++;
            }

            Console.WriteLine(changed);

        }
    }
}
