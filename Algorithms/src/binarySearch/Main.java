package binarySearch;

public class Main {
    public static void main(String[] args) {

        int[] sortedArray = {1,2,5,6,11,66,441,1234};

        int end = sortedArray.length-1;
        int searchingNumber = 66;

        int startIndex = 0;

       int found =  binarySearch(sortedArray, end, searchingNumber, startIndex);
        System.out.println(found);
    }

    public static int binarySearch(int[] sortedArray, int end, int searchingNumber, int startIndex) {

        if (end>=1) {
            int middle = startIndex + (end - startIndex) / 2;
            if (sortedArray[middle] == searchingNumber) {
                return middle;
            }

            if(sortedArray[middle]>searchingNumber)
            {
                binarySearch(sortedArray,middle-1,searchingNumber,startIndex);
            }
            else binarySearch(sortedArray,end,searchingNumber,middle);

        }
        return -1;

    }
}
