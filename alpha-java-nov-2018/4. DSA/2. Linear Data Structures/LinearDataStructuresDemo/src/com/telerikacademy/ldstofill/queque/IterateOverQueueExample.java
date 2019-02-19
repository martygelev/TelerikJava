package com.telerikacademy.ldstofill.queque;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IterateOverQueueExample {
    public static void main(String[] args) {

        // Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();

        waitingQueue.add("John");
        waitingQueue.add("Brad");
        waitingQueue.add("Angelina");
        waitingQueue.add("Julia");

        System.out.println("=== Iterating over a Queue using Java 8 forEach() ===");

        System.out.println("\n=== Iterating over a Queue using iterator() ===");

        System.out.println("\n=== Iterating over a Queue using iterator() and Java 8 forEachRemaining() ===");

        System.out.println("\n=== Iterating over a Queue using simple for-each loop ===");

    }
}
