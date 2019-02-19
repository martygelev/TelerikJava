package ok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shuffle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] firstRow = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n= firstRow[0];
        int k = firstRow[1];

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i]=i+1;
        }


        int[] steps = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> swapped = new ArrayList<>();

        for (int i : array) {
            swapped.add(i);
        }

        for (int step : steps) {



            int index ;
            int newIndex;
            if (step%2==0){
                index=swapped.indexOf(step);
                swapped.remove(index);

                int element = step/2;

                newIndex=swapped.indexOf(element);

                swapped.add(newIndex+1,step);
            }
            if (step%2==1){

                index=swapped.indexOf(step);

                int element = step*2;

                if (element>swapped.size()-1){
                    element=swapped.get(swapped.size()-1);
                }
                if (swapped.get(swapped.size()-2)==step){
                    continue;
                }
                if (swapped.get(swapped.size()-1)==step){
                    continue;
                }
                swapped.remove(index);


                newIndex=swapped.indexOf(element);

                swapped.add(newIndex+1,step);

            }

        }

        for (int i = 0; i < swapped.size()-1; i++) {
            System.out.print(swapped.get(i)+" ");

        }
        System.out.print(swapped.get(swapped.size()-1));
    }
}
