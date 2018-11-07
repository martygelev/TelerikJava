using System;
using System.Linq;
namespace Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int number =0;


            while (input!= "end")
            {
                if (input.Contains("set"))
                {
                    string[] arr =   input.Split(new char[]{' '}).ToArray();
                    number = int.Parse(arr[1]);
                    input = Console.ReadLine();

                }

                if (input.Contains("front-add"))
                {
                    string[] arr = input.Split(new char[] { ' ' }).ToArray();

                    string digit = number.ToString();
                    string add = arr[1];
                    int replace = int.Parse(digit.Insert(0, add));

                    number = replace;
                    input = Console.ReadLine();

                }
                //back-add DIGIT
                if (input.Contains("back-add"))
                {
                    string[] arr =   input.Split(new char[]{' '}).ToArray();

                    string digit = number.ToString();
                    string add = arr[1];
                    int replace = int.Parse(digit.Insert(digit.Length, add));

                    number = replace;
                    input = Console.ReadLine();

                }

                if (input == "back-remove")
                {
                    string temp = number.ToString();
                    temp.Remove((temp.Length-1));
                    number = int.Parse(temp);
                    input = Console.ReadLine();
                
                }

                if (input== "front-remove")
                {
                    char[] temp = number.ToString().ToCharArray();
                    temp = temp.Skip(1).ToArray();
                    string sh = new string(temp);
                    number = int.Parse(sh);
                    input = Console.ReadLine();
                
                }
                    
                if (input == "reverse")
                {
                    string temp = number.ToString();
                   char[] sh= temp.ToCharArray();
                    char[]n= sh.Reverse().ToArray();

                    string result = new string(n);

                    number = int.Parse(result);
                    input = Console.ReadLine();
                }

                if (input=="print")
                {
                    Console.WriteLine(number);
                    input = Console.ReadLine();
                }

            }
        }
    }
}
