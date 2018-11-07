using System;
using System.Collections.Generic;
using System.Linq;

namespace random3
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> collectionOfScores = new List<int>();

            // read input 
            while(true)
            {
                Console.Write("Please enter homework score [0 to 100] (-99 to exit): ");
                int score = int.Parse(Console.ReadLine());

                if (score==-99)
                {
                    break;
                }

                collectionOfScores.Add(score);
            }

            //Sort the list so we can remove highest and lowest 
            collectionOfScores.Sort();

            int lowest = collectionOfScores[0];
            collectionOfScores.Remove(lowest); // remove first

            int highest = collectionOfScores.Last();
            collectionOfScores.Remove(highest); // remove last

            double averageScore = collectionOfScores.Sum() / collectionOfScores.Count();

            //Print result
            Console.WriteLine("Homework App");
            Console.WriteLine($"Highest Score: {highest}");
            Console.WriteLine($"Lowest Score: {lowest}");

            Console.WriteLine(); // empty row


            Console.WriteLine($"Average Score (excluding lowest & highest scores): {averageScore:f1}");
        }
    }
}
