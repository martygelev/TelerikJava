package com.telerikacademy.tasks.Recursion;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSortDemoTimeChallenge {

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

        List<Integer> randomGeneratedList = generateRandomListInRange(500000, 10000);

        long startTime = System.nanoTime();
        quickSort(randomGeneratedList);
        long endTime = System.nanoTime();
        long durationCustomMade = endTime - startTime;

        long startTime2 = System.nanoTime();
        randomGeneratedList.sort(Comparator.naturalOrder());
        long endTime2 = System.nanoTime();
        long durationBuildIn = endTime2 - startTime2;

        System.out.println("Custom Time: " + durationCustomMade);
        System.out.println("BuildIn Time: " + durationBuildIn);
        System.out.println("Rate: " + durationCustomMade/durationBuildIn);

    }

    private static List<Integer> quickSort(List<Integer> listToSort) {
        if (listToSort.size() <= 1) {
            return listToSort;
        }

        int pivot = listToSort.get(0);
        List<Integer> lesser = listToSort.stream().filter(x -> x < pivot).collect(Collectors.toList());
        List<Integer> pivots = listToSort.stream().filter(x -> x == pivot).collect(Collectors.toList());
        List<Integer> greater = listToSort.stream().filter(x -> x > pivot).collect(Collectors.toList());

        lesser = quickSort(lesser);
        greater = quickSort(greater);


        List<Integer> result = Stream.concat(lesser.stream(), pivots.stream()).collect(Collectors.toList());
        result = Stream.concat(result.stream(), greater.stream()).collect(Collectors.toList());
        return result;
    }




}
