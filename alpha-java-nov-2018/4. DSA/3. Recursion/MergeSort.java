package com.telerikacademy.tasks.Recursion;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeSort {

    private static List<Integer> returnListOfIntegers() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(6);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(100);
        list.add(110);
        list.add(10);
        list.add(1);
        list.add(111);
        list.add(12);
        return list;
    }

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

//        List<Integer> listToSort = returnListOfIntegers();
//        listToSort.forEach(System.out::println);

        List<Integer> randomList = generateRandomListInRange(6, 33);
        randomList.forEach(System.out::println);

        System.out.println("--------");

//        List<Integer>[] result = split(randomList);
//        result[0].forEach(System.out::println);
//        System.out.println("---");
//        result[1].forEach(System.out::println);

        mergeSortOther(randomList).forEach(System.out::println);

//        mergeSort(randomList).forEach(System.out::println);

    }

    private static List<Integer> mergeSort(List<Integer> listToSort) {
        if (listToSort.size() == 1) {
            return listToSort;
        }
        int middle = listToSort.size()/2;

        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        for (int i = 0; i < middle; i++) {
            left.add(listToSort.get(i));
        }
        for (int i = middle; i < listToSort.size(); i++) {
            right.add(listToSort.get(i));
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return combineTwoSortedLists(left, right);
    }

    private static List<Integer> mergeSortOther(List<Integer> listToSort) {
        if (listToSort.size() <= 1) {
            return listToSort;
        }

        List<Integer >[] splitList = split(listToSort);
        List<Integer> left = splitList[0];
        List<Integer> right = splitList[1];


        left = mergeSortOther(left);
        right = mergeSortOther(right);
        return combineTwoSortedLists(left, right);
    }

    private static <T> List[] split(List<T> list) {

        // get size of the list
        int size = list.size();

        // construct new list from the returned view by list.subList() method
        List<T> first = new LinkedList<>(list.subList(0, (size + 1)/2));
        List<T> second = new LinkedList<>(list.subList((size + 1)/2, size));

        // return an List array to accommodate both lists
        return new List[] {first, second};
    }

    private static List<Integer> combineTwoSortedLists(List<Integer> left, List<Integer> right) {
        List<Integer> result = new LinkedList<>();
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        while (!left.isEmpty()) {
            result.add(left.get(0));
            left.remove(0);
        }
        while (!right.isEmpty()) {
            result.add(right.get(0));
            right.remove(0);
        }
        return result;
    }
}
