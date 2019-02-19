package com.telerikacademy.ldstofill.linkedlist;

import java.util.LinkedList;

public class RetrieveLinkedListElementsExample {
    public static void main(String[] args) {

        // A LinkedList containing Stock Prices of a company for the last 6 days
        LinkedList<Double> stockPrices = new LinkedList<>();

        stockPrices.add(45.00);
        stockPrices.add(51.00);
        stockPrices.add(62.50);
        stockPrices.add(42.75);
        stockPrices.add(36.80);
        stockPrices.add(68.40);

        // Getting the first element in the LinkedList using getFirst()
        // The getFirst() method throws NoSuchElementException if the LinkedList is empty

        // System.out.println("Initial Stock Price : " + firstElement);

        // Getting the last element in the LinkedList using getLast()
        // The getLast() method throws NoSuchElementException if the LinkedList is empty

        // System.out.println("Current Stock Price : " + lastElement);

        // Getting the element at a given position in the LinkedList

        // System.out.println("Stock Price on 3rd Day : " + stockPriceOn3rdDay);
    }
}
