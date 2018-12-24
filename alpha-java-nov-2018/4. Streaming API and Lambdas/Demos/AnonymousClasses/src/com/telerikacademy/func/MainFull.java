package com.telerikacademy.func;

import com.telerikacademy.models.Bookmark;
import com.telerikacademy.models.BookmarkListFactory;

import java.net.MalformedURLException;
import java.util.*;
import java.util.function.*;

// Test if this is abstract class with abstract method
interface Test {
    void go();

    // Test that lambda works only with functional interfaces
    //void stop();

    // Every class we know implicitly inherits from the Object class so that implementation is already there.
    //String toString();
}

public class MainFull {
    public static final Comparator<Bookmark> SORT_BOOKMARKS_BY_RATING = new Comparator<Bookmark>() {
        @Override
        public int compare(Bookmark o1, Bookmark o2) {
            if (o1.getRating() == o2.getRating()) {
                return o1.getTitle().compareTo(o2.getTitle());
            } else {
                return o1.getRating() < o2.getRating() ? 1 : -1;
            }
        }
    };

    public static void main(String[] args) {
        List<Bookmark> recommendedItems = BookmarkListFactory.getBookmarkList();

        for (Bookmark b : recommendedItems) {
            System.out.println(b);
        }

        // Use anonymous class to implement comparator in order to sort items
        recommendedItems.sort(new Comparator<Bookmark>() {

            @Override
            public int compare(Bookmark o1, Bookmark o2) {
                return o1.getRating() < o2.getRating() ? 1 : -1;
            }
        });

        // Use constant for anonymous class
        recommendedItems.sort(SORT_BOOKMARKS_BY_RATING);

        System.out.println("\nSorted by rating:");
        for (Bookmark b : recommendedItems) {
            System.out.println(b);
        }

        // Use lambda to implement comparator in order to sort items
        recommendedItems.sort((Bookmark o1, Bookmark o2) -> {
            return o1.getRating() < o2.getRating() ? 1 : -1;
        });

        // Use lambda expression to implement comparator in order to sort items
        // Compiler assumes the type of the parameters based on declaration
        recommendedItems.sort((o1, o2) -> o1.getRating() < o2.getRating() ? 1 : -1);

        // Test that lambda works only with functional interfaces
        go(() -> System.out.println("go go go!"));

        // Test variables in different scopes
        int i = 0;

        // cannot do that because the variable should be effectively final
        // i++;

        // access local variable - capturing the variable - closure
        go(() -> System.out.println("go go go! " + i));

        //access global static variable
        go(() -> System.out.println("go go go! " + global));

        // you can change the static variable
        global++;

        // Test Predicate filter
        System.out.println("\nFiltered by rating");
        for (Bookmark b : recommendedItems) {
            if (filter(b, bb -> bb.getRating() > 4.0)) {
//                b = transform(b, bb -> {
//                    bb.setPopular(true);
//                    return bb;
//                });

                Function<Bookmark, Bookmark> makePopularFunc = bb -> {
                    bb.setPopular(true);
                    return bb;
                };

                Function<Bookmark, Bookmark> addToFavFunc = bb -> {
                    bb.addToFavourites();
                    return bb;
                };

                // composition of functions
                Function<Bookmark, Bookmark> handleBigRate = makePopularFunc.andThen(addToFavFunc);

                b = transform(b, handleBigRate);
//
//                b = transform.apply(b);

                System.out.println(b);
            }
        }

        // Demonstrate Consumer functional interface
        System.out.println("Get ids...");
        recommendedItems.forEach(bb -> System.out.println(bb.getId()));

        // Demonstrate Supplier
        Random randomGenerator = new Random();
        for (Bookmark b : recommendedItems) {
            if (randomGenerator.nextInt(5) < 3) {
                print(() -> { return "No network access to get info for " + b.getId();});
            }
        }

    }

    public static int global = 10;

    public static void go(Test t) {
        t.go();
    }

    static boolean filter(Bookmark bookmark, Predicate<Bookmark> filter) {
        return filter.test(bookmark);
    }

    static Bookmark transform(Bookmark bookmark, Function<Bookmark, Bookmark> transformer) {
        return transformer.apply(bookmark);
    }

    // show unary & bifunctional interfaces

    //show Supplier & flag

    private static boolean errorFlag = true;

    private static void print(Supplier<String> supplier) {
        if (errorFlag) {
            System.out.println(supplier.get());
        }
    }
}
