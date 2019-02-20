package dsa;

public class task3 {
    public static void main(String[] args) {
        int[] first = {4, 1, 2};
        int[] second = {1, 3, 4, 2};

        int[] newArr = nextGreaterElement(first, second);

        for (int i = 0; i < newArr.length; i++) {
            int el = newArr[i];

            if (el == 0) {
                newArr[i] = -1;
            }

            System.out.print(newArr[i] + ",");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int currentValue = nums1[i];

            for (int j = 0; j < nums2.length; j++) {
                int val = nums2[j];

                if (currentValue == val) {
                    int z = j;
                    while (z < nums2.length) {
                        if (nums2[z] > currentValue) {
                            arr[i] = nums2[z];
                            break;
                        }
                        z++;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }

        }

        return arr;
    }
}
