using System;
 
    class kaspichan
    {
        static void Main(string[] args)
        {
            ulong n = ulong.Parse(Console.ReadLine());
            string[] digits = new string[256];
            int counter = 0;
 
            for (char i = 'A'; i <= 'Z'; i++)
            {
                digits[counter] = Convert.ToString(i);
                counter++;
            }
            for (char i = 'a'; i <= 'h'; i++)
            {
                for (char j = 'A'; j <= 'Z'; j++)
                {
                    digits[counter] = i.ToString() + j.ToString();
                    counter++;
                }
            }
            for (char i = 'A'; i <= 'V'; i++)
            {
                digits[counter] = "i" + i.ToString();
                counter++;
            }
               
 
            string number = "";
            if (n == 0)
                Console.WriteLine("A");
         
            while (n != 0)
            {
                number = digits[n % 256] + number;
                n = n / 256;
            }
            Console.WriteLine(number);
        }
    }