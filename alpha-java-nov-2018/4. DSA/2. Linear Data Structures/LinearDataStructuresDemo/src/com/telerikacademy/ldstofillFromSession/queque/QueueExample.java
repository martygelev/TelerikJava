package com.telerikacademy.ldstofillFromSession.queque;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        // Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();
//        waitingQueue.offer("Person 1");
//        waitingQueue.offer("Person 2");
//        waitingQueue.offer("Person 3");
//        waitingQueue.offer("Person 4");

        System.out.println("WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using remove() (The Dequeue operation)
        // The remove() method throws NoSuchElementException if the Queue is empty
        //String name = waitingQueue.remove();

        //System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);
         String name = waitingQueue.poll();
        // Removing an element from the Queue using poll()
        // The poll() method is similar to remove() except that it returns null if the Queue is empty.

        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);
    }
}
