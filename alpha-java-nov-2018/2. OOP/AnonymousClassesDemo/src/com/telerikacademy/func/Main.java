package com.telerikacademy.func;

import com.telerikacademy.models.Bookmark;
import com.telerikacademy.models.BookmarkListFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<Bookmark> recommendedItems = BookmarkListFactory.getBookmarkList();

        for (Bookmark b : recommendedItems) {
            System.out.println(b);
        }

        // Use anonymous class to implement comparator in order to sort items

        // Use lambda to implement comparator in order to sort items

        // Use lambda expression to implement comparator in order to sort items
        // Compiler assumes the type of the parameters based on declaration
        // Get to know ternary operator

        System.out.println("\nSorted by rating:");
        for (Bookmark b : recommendedItems) {
            System.out.println(b);
        }

        // Test that lambda works only with functional interfaces
        // Create functional interface, method that accepts argument of its type and calls the method. Use it to create lambda
        // Add another not implemented method
        // Add default method
        // override toString()
        // Change the interface to abstract class with one abstract method

        // Test variables in different scopes:
        // access local variable - capturing the variable - closure.
        // Try to change the variable. The local variable should be effectively final
        // Add static field in the class try to use it. Try to change it.

        // Test that lambda closures cannot hide variables

        // Test Predicate filter
        System.out.println("\nFiltered by rating");
        for (Bookmark b : recommendedItems) {
            // get all items that have rating bigger than 4.0, using the Predicate<T>
            // create  static filter method for Bookmark items & use it

            // Create static transform method that uses Function<Bookmark, Bookmark> that changes the popularity of the bookmark based on the filter.

            // If bookmark is popular - add it to favourites - create another function, chain both, passed the chain as parameter to transform.

            // Explain UnaryOperator & BiFunction

            System.out.println(b);

        }

        // Demonstrate Consumer functional interface using forEach function
        System.out.println("Get ids...");

        // Demonstrate Supplier using improvised "network access error message"
        Random randomGenerator = new Random();
        for (Bookmark b : recommendedItems) {
            if (randomGenerator.nextInt(5) < 3) {
                // Handle error: "No network access to get info for ";
                // use static flag to avoid execution of supplier's get
            }
        }

    }
}
