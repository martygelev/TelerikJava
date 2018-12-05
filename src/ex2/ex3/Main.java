package ex2.ex3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
     //working 100/100
    static int position;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

         position = Integer.parseInt(in.nextLine());
        int[] array = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        String input = in.nextLine();
        int forwardSum=0;
        int backWardSum=0;


        while (!input.equals("exit"))
        {
            String[] split = input.split(" ");
            int times = Integer.parseInt(split[0]);
            String where = split[1];
            int step = Integer.parseInt(split[2]);

            if (where.equals("forward"))
            {
                while (times-->0)
                {
                    position=position+step;
                    while (position>array.length-1)
                    {
                        position-=array.length;
                    }
                    forwardSum+=array[position];
                }
            }
            else if (where.equals("backwards"))
            {
                while (times-->0)
                {
                    position=position-step;

                    while (position<0)
                    {
                        position+=array.length;
                    }
                    backWardSum+=array[position];
                }
            }
            input = in.nextLine();
        }

        System.out.println("Forward: " + forwardSum);
        System.out.println("Backwards: "+ backWardSum);
    }
}
