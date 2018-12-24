package com.telerikacademy;

import java.util.Arrays;

public class JavaTypes {
    public static void main(String[] args) {
        int x = 5;
        int y = x;

        System.out.println(x);
        System.out.println(y);
        System.out.println();

        y = 6;

        System.out.println(x);
        System.out.println(y);
        System.out.println();

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = array1;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println();

        array1[1] = 0;
        array2[0] = 10;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println();

        Arrays.sort(array1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println();

        array2 = Arrays.copyOf(array1, array1.length);
        array2[0] = 100;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println();
    }
}
