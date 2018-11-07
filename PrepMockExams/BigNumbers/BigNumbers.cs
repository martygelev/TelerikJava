using System;
using System.Linq;

public class Program
{
    public static void Main()
    {

        /* with Java is 1000 times better
         * import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigNumbers {
    public static void main(String[] args) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       in.readLine();
       String[] array1 = in.readLine().split(" ");
       String[] array2 = in.readLine().split(" ");
       int[] sum = new int[Math.max(array1.length, array2.length)];
       for(int i = 0; i < sum.length; i++) {
          if(i < array1.length)
             sum[i] += Integer.parseInt(array1[i]);
          if(i < array2.length)
             sum[i] += Integer.parseInt(array2[i]);
          if(sum[i] > 9) {
             sum[i] %= 10;
             if(i < sum.length)
                sum[i + 1] += 1;
          }
          System.out.print(sum[i] + " ");
       }
    }
}
*/

        int[] input1 = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

        int input = input1[0];

        int input2 = input1[1];
        
        int[] arrInput = Console.ReadLine().Split(new char[]{' '},
                                                    StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
        
        int[] arrInput2 = Console.ReadLine().Split(new char[]{' '},
                                                    StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
            
        int bigger = Math.Max(arrInput.Length, arrInput2.Length);
        int smaller = Math.Min(arrInput.Length, arrInput2.Length);
        
        int[] final = new int[bigger];
         final=CalculateNewArray(smaller, bigger, arrInput,arrInput2, final);
        
        foreach(int element in final)
        {
            Console.Write(element + " ");
        }
        Console.WriteLine();
    }
    
    public static int[] CalculateNewArray(int smaller, int bigger,int[] arrInput, int[] arrInput2, int[] final)
    {

        int overTen = 0;
        int nextAdd = 0;
        int sum = 0;

        for (int i =0; i<smaller; i++)
        {
            int current =0;
            sum = arrInput[i] + arrInput2[i];
            if(sum>=10)
            {
                overTen = sum%10;
               // sum = overTen;
                
                    if (current +1==i)
                    {
                    final[i]=overTen + nextAdd;
                    nextAdd = 0;
                    }
                    
                    else 
                    {
                    final[i] = overTen + nextAdd;
                    nextAdd = 0;
                    }
                nextAdd = sum / 10;

                current = i;
            }
            
            else
            {
                final[i] = sum + nextAdd;
                nextAdd = 0;
            }
            sum = 0;
        }
       //int diff = bigger- smaller;
        
        for (int i=smaller; i<bigger; i++)
        {
            if(arrInput.Length>arrInput2.Length)
            {
                            final[i] =  arrInput[i];
            }
            else if (arrInput.Length<arrInput2.Length)
            {
                final[i] =  arrInput2[i];
            }
        }
             return final;
 }
}
 