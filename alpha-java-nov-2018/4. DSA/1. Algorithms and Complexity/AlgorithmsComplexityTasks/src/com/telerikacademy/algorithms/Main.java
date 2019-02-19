package com.telerikacademy.algorithms;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    // Calculates the product of a & b. What is the runtime?
    int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }

        return sum;
    }

    // Calculates a^b. What is the runtime?
    int power(int a, int b) {
        if (b < 0) {
            return 0;
        }

        if (b == 0) {
            return 1;
        }

        return a * power(a, b - 1);
    }

    // Calculates a % b. What is the runtime?
    int mod(int a, int b) {
        if (b < 0) {
            return -1;
        }

        int div = a / b;
        return a - div * b;
    }

    // Performs integer division. What is the runtime? Assume a,b > 0
    int div(int a, int b) {
        if (b < 0) {
            return -1;
        }

        int sum = 0;
        int count = 0;

        while (sum <= a) {
            sum += b;
            count++;
        }

        return count;
    }


    // The following code computes the [integer) square root of a number. If the number is not a
    // perfect square (there is no integer square root), then it returns -1 .It does this by successive
    // guessing. If n is 100, it first guesses 5.0 Too high? Try something lower - halfway between 1
    // and 5O. What is its runtime?

    int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; //no square root
        int guess = (min + max); // 2;
        if (guess * guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    // The following code computes the [integer) square root of a number. If the number is not
    // a perfect square (there is no integer square root), then it returns -1. It does this by trying
    // increasingly large numbers until it finds the right value (or is too high). What is its runtime?
    int sqrt_increase(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    // If a binary search tree is not balanced, how long might it take (worst case) to find an element
    // in it?

    // You are looking for a specific value in a binary tree, but the tree is not a binary search tree.
    // What is the time complexity of this?

    // The appendToNew method appends a value to an array by creating a new, longer array and
    // returning this longer array. You've used the appendToNew method to create a copyArray
    // function that repeatedly calls appendToNew. How long does copying an array take?
    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }
        // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
    }

    // The following code sums the digits in a number. What is its big O time?
    int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // The following code prints all strings of length k where the characters are in sorted order. It
    // does this by generating all strings of length k and then checking if each is sorted. What is its
    // runtime?
    int numChars = 26;

    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            } else {
                for (int i = 0; i < numChars; i++) {
                    char c = ithLetter(i);
                    printSortedStrings(remaining - 1, prefix + c);
                }
            }
        }
    }

    boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    char ithLetter(int i) {
        return (char) ((int) 'a' + i);
    }

    // The following code computes the intersection (the number of elements in common) of two
    // arrays. It assumes that neither array has duplicates. It computes the intersection by sorting
    // one array (array b) and then iterating through array a checking (via binary search) if each
    // value is in b. What is its runtime?

    int intersection(int[] a, int[] b) {
        mergesort(b);
        int intersect = 0;
        for (int x : a) {
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }
        return intersect;
    }

    void mergesort(int[] arr) {
        // merge sort implementation here
    }

    int binarySearch(int[] arr, int elem) {
        // binary search implementation here
         return 0;
    }
}
