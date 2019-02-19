package com.telerikacademy.ldstofill.queque;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSizeSearchFrontExample {
    public static void main(String[] args) {

        // Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();

        waitingQueue.add("Jennifer");
        waitingQueue.add("Angelina");
        waitingQueue.add("Johnny");
        waitingQueue.add("Sachin");

        // System.out.println("WaitingQueue : " + waitingQueue);

        // Check is a Queue is empty
        // System.out.println("is waitingQueue empty? : " +);

        // Find the size of the Queue
        // System.out.println("Size of waitingQueue : " + );

        // Check if the Queue contains an element
        // System.out.println("WaitingQueue contains " + name);
        // System.out.println("Waiting Queue doesn't contain " + name);


        // Get the element at the front of the Queue without removing it using element()
        // The element() method throws NoSuchElementException if the Queue is empty

       //System.out.println("First Person in the Waiting Queue (element()) : " + firstPersonInTheWaitingQueue);

        // Get the element at the front of the Queue without removing it using peek()
        // The peek() method is similar to element() except that it returns null if the Queue is empty

        // System.out.println("First Person in the Waiting Queue : " + firstPersonInTheWaitingQueue);

    }
}
