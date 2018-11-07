using System;
 
class pier
{
    static void Main()
    {
        byte n = byte.Parse(Console.ReadLine());
        string[] secondLine = Console.ReadLine().Split(' ');
        int[] statueWeight = new int[n];
        int[] difference = new int[(1 << n) - 1];
        int minDifference = 100000;
        int subSetSum = 0;
        int sumOfAll = 0;
 
        for (int i = 0; i < statueWeight.Length; i++)
        {
            statueWeight[i] = int.Parse(secondLine[i]);
            sumOfAll += statueWeight[i];
        }
        for (int mask = (1 << n) - 1; mask > 0; mask--)
        {
            for (int i = 0; i < statueWeight.Length; i++)
            {
                if ((mask & (1 << i)) == (1 << i))
                {
                    subSetSum += statueWeight[i];
                }
            }
            if (minDifference > Math.Abs(subSetSum - (sumOfAll - subSetSum)))
            {
                minDifference = Math.Abs(subSetSum - (sumOfAll - subSetSum));
            }
            subSetSum = 0;
        }
        Console.WriteLine(minDifference);
    }
}