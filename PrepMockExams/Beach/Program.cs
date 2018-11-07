using System;
using System.Linq;

namespace Beach
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] firstTime = Console.ReadLine()
                                     .Split(new char[] { ' ' },
                                                       StringSplitOptions.RemoveEmptyEntries)
                                     .Select(int.Parse)
                                     .ToArray();
            
         /* int[] secondTime = Console.ReadLine()
                                      .Split(new char[] { ' ' },
                                                        StringSplitOptions.RemoveEmptyEntries)
                                      .Select(int.Parse)
                                      .ToArray();
           */

            int startFirst = firstTime[0] * 60 + firstTime[1];
            int endFirst = firstTime[2] * 60 + firstTime[3];
            int startSecond = firstTime[4] * 60 + firstTime[5];
            int endSecond = firstTime[6] * 60 + firstTime[7];

            int chanceStart = Math.Max(startFirst, startSecond);
            int endChance = Math.Min(endFirst, endSecond);

            if (endChance >= chanceStart)
            {
                int startMeetHours = (int)chanceStart / 60;
                int startMeetMin = chanceStart % 60;

                int endMeetHours = (int)endChance / 60;
                int endMeetMin = endChance % 60;

                Console.WriteLine($"{startMeetHours} {startMeetMin} {endMeetHours} {endMeetMin}");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
