package com.telerikacademy.ldstofill.linkedlist;

import java.util.LinkedList;

public class IterateOverLinkedListExample {
    public static void main(String[] args) {

        // Create LinkedList with Human species
        LinkedList<String> humanSpecies = new LinkedList<>();

        humanSpecies.add("Homo Sapiens");
        humanSpecies.add("Homo Neanderthalensis");
        humanSpecies.add("Homo Erectus");
        humanSpecies.add("Home Habilis");

        System.out.println("=== Iterate over a LinkedList using Java 8 forEach and lambda ===");

        System.out.println("\n=== Iterate over a LinkedList using iterator() ===");

        System.out.println("\n=== Iterate over a LinkedList using iterator() and Java 8 forEachRemaining() method ===");

        System.out.println("\n=== Iterate over a LinkedList using descendingIterator() ===");

        System.out.println("\n=== Iterate over a LinkedList using listIterator() ===");
        // ListIterator can be used to iterate over the LinkedList in both forward and backward directions
        // In this example, we start from the end of the list and traverse backwards

        System.out.println("\n=== Iterate over a LinkedList using simple for-each loop ===");

    }
}
