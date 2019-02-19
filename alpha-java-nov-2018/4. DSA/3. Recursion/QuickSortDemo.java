package com.telerikacademy.tasks.Recursion;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSortDemo {

    private static List<Integer> generateRandomListInRange(int listSize, int maxIntValue) {

        int[] array = new int[listSize];

        Random random = new Random();

        IntUnaryOperator unaryOpInt = (p) -> random.nextInt(maxIntValue + 1);
        // populate array a with random numbers
        Arrays.setAll(array, unaryOpInt);

        // Since we want to return List<> we can
        // create ArrayList from array as follows.

        List<Integer> arrList = new ArrayList<>(IntStream.of(array).boxed().collect(Collectors.toList()));

        return arrList;
    }
    public static void main(String[] args) {

        List<Integer> randomGeneratedList = generateRandomListInRange(15, 100);

        randomGeneratedList.forEach(x -> System.out.printf("%d, ", x));

        System.out.println();
        System.out.println();

        quickSort(randomGeneratedList).forEach(x -> System.out.printf("%d, ", x));
    }

    private static List<Integer> quickSort(List<Integer> listToSort) {
        if (listToSort.size() <= 1) {
            return listToSort;
        }

        int pivot = listToSort.get(0);

        List<Integer> lesser = listToSort.stream()
                .skip(1)
                .filter(x -> x <= pivot)
                .collect(Collectors.toList());
        List<Integer> greater = listToSort.stream()
                .filter(x -> x > pivot)
                .collect(Collectors.toList());

        lesser = quickSort(lesser);
        lesser.add(pivot);
        greater = quickSort(greater);

        return Stream.concat(lesser.stream(), greater.stream()).collect(Collectors.toList());
    }
}
