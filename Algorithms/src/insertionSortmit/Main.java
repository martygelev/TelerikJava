package insertionSortmit;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{5,1,4,8,3,2,6,11,2,0,0,0,1,1,3,4,1,1,123421,31213,22,123123,2211,123131,11,-2,-1,-5,-100};
        insertionSort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    public static void insertionSort(int [] array )
    {
        for (int i = 1; i<array.length; i++)
        {
          int currentIndex=i;
            int previousIndex = i-1;

            //5,1,4,8,3,2,6,11,2

            while (previousIndex>=0 && array[previousIndex]>array[currentIndex])
            {
              int  key  = array[previousIndex];
                array[previousIndex]=array[currentIndex];
                array[currentIndex]= key;
                previousIndex--;
                currentIndex--;

            }
        }
    }
}
