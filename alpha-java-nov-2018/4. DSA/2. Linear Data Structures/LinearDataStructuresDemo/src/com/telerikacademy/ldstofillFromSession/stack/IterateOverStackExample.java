package com.telerikacademy.ldstofillFromSession.stack;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class IterateOverStackExample {
    public static void main(String[] args) {

        // Creating a Stack stackOfPlates
        Stack<String> stackOfPlates = new Stack<>();

        stackOfPlates.add("Plate 1");
        stackOfPlates.add("Plate 2");
        stackOfPlates.add("Plate 3");
        stackOfPlates.add("Plate 4");

        System.out.println("=== Iterate over a Stack using Java 8 forEach() method ===");
        stackOfPlates.forEach(System.out::println);

        System.out.println("\n=== Iterate over a Stack using iterator() ===");


        System.out.println("\n=== Iterate over a Stack using iterator() and Java 8 forEachRemaining() method ===");


        System.out.println("\n=== Iterate over a Stack from TOP to BOTTOM using listIterator() ===");
        // ListIterator allows you to traverse in both forward and backward directions.
        // We'll start from the top of the stack and traverse backwards.

        ListIterator<String> iterator = stackOfPlates.listIterator(stackOfPlates.size());
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
