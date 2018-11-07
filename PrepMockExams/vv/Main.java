package  com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main()
    {
        Scanner in = new Scanner(System.in);


        int sssss = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String[] firstStrings = in.nextLine().split(" ");
        String[] secondStrings = in.nextLine().split(" ");

        sssss = firstStrings.length;
        m = secondStrings.length;

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (String firstS : firstStrings)
        {
            first.add(Integer.parseInt(firstS));
        }

        for (String secondS : secondStrings)
        {
            second.add(Integer.parseInt(secondS));
        }

        int max = Math.max(sssss, m);
        int remainder = 0;
        ArrayList<Integer> result = new ArrayList<>(max);
        int firstAdd;
        int secondAdd;

        for (int i = 0; i < max; i++)
        {



            if (i >= first.size())
            {
                firstAdd = 0;
            }
            else
            {
                firstAdd = first.get(i);
            }
            if (i >= second.size())
            {
                secondAdd = 0;
            }
            else
            {
                secondAdd = second.get(i);
            }


            int digit = firstAdd + secondAdd + remainder;
            if (digit >= 10)
            {
                remainder = digit / 10;
                digit = digit % 10;
            }
            else
            {
                remainder = 0;
            }
            result.add(i, digit);
            if (i == max - 1)
            {
                System.out.print(result.get(i));
            }
            else
            {
                System.out.print(result.get(i) + " ");
            }
        }

    }
}
