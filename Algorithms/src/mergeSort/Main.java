package mergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Merge Sort");
        System.out.println("Please enter array separated by space: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] inputArray = Arrays.stream(reader.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();

        int endIndex = inputArray.length-1;

        int startIndex = 0;

        mergeSort(inputArray, startIndex,endIndex);

        System.out.println("MAGIC ...");

        for (long i : inputArray) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(long[] inputArray, int startIndex, int endIndex) {

        if (startIndex>=endIndex)
        {
            return;
        }
        int middleIndex = (startIndex+endIndex)/2;

        mergeSort(inputArray,startIndex,middleIndex);//left side
        mergeSort(inputArray,middleIndex+1,endIndex);//right side

        merge(inputArray, startIndex, middleIndex,endIndex);
    }

    public static void merge(long[] inputArray, int startIndex,int middleIndex,int endIndex) {

        //check if already sorted
        if (middleIndex<0 || middleIndex+1>=inputArray.length
        || inputArray[middleIndex]<=inputArray[middleIndex+1])
        {
            return;
        }

        long[] helper = new long[inputArray.length];
        System.arraycopy(inputArray,0,helper,0,inputArray.length);

        int leftIndex =startIndex;
        int rightIndex = middleIndex+1;

        for (int i=startIndex; i<=endIndex;i++)
        {
            if (leftIndex>middleIndex)
            {
                inputArray[i]=helper[rightIndex++];
            }
            else if (rightIndex>endIndex)
            {
                inputArray[i]=helper[leftIndex++];
            }
             else if (helper[leftIndex]<=helper[rightIndex])
            {
                inputArray[i]=helper[leftIndex++];
            }
            else
            {
                inputArray[i]=helper[rightIndex++];
            }
        }
    }
}