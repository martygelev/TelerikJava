package quickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int lastIndex = array.length-1;

        quickSort(array,0,lastIndex);

        for (int i :array
             ) {
            System.out.print(i + " ");
        }

    }
    public static void quickSort(int[] array,int low,int high)
    {
        if (low<high+1)
        {
            int p=partition(array,low,high);
            quickSort(array,low,p-1);
            quickSort(array,p+1,high);

        }
    }

    public static void swap(int[] array, int firstIndex , int secondIndex)
    {
        int temp = array[firstIndex];
        array[firstIndex]=array[secondIndex];
        array[secondIndex]=temp;
    }

    public static int getPivot(int low, int high)
    {
        Random random = new Random();
        return random.nextInt((high-low)+1)+low;
    }

    public static int partition (int[] array,int low, int high)
    {
        swap(array,low,getPivot(low,high));
        int border = low+1;

        for (int i =border; i <=high; i++)
        {
            if (array[i]<array[low])
            {
                swap(array,i,border++);
            }
        }
        swap(array,low,border-1);
        return border-1;
    }
}
