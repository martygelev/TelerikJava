package com.telerikacademy.streams;

import com.telerikacademy.models.Bookmark;
import com.telerikacademy.models.BookmarkListFactory;
import com.telerikacademy.models.Review;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Bookmark> recommendedItems = BookmarkListFactory.getBookmarkList();

        // Iteration.
        // Substitute for, for-each and while loops.
        // Allows concentrating on operation’s logic, but not on the iteration over the sequence of elements.
        for (Bookmark b : recommendedItems) {
            if (b.getTitle().contains("Java")) {
                System.out.println("Yes!");
                break;
            }
        }

        // use stream, anyMatch

        // Filtering
        // The filter() method allows us to pick stream of elements which satisfy a predicate
        // Get all bookmarks that contain Java in their title

        // use stream, filter

        // Mapping
        // To convert elements of a Stream by applying a special function to them and to collect these new elements into a Stream,
        // we can use the map() method.

        // use stream, map
        // Get rounded up ratings for all bookmarks

        // use stream, flatMap
        // Get all reviews that are waiting for approval

        // Matching
        // Stream API gives a handy set of instruments to validate elements of a sequence according to some predicate.
        // To do this one of the following methods can be used: anyMatch(), allMatch(), noneMatch().
        // Their names are self-explaining. Those are terminal operations which return a boolean.

        // use stream, anyMatch(), allMatch(), noneMatch()
        // test if there is item containing in its title "Java"
        // test if all items has rating bigger than 2.0
        // test if any item has rating lower than 2.0


        // Reduction
        // Stream API allows reducing a sequence of elements to some value according to a specified function with the help of the reduce() method.
        // This method takes two parameters: first – start value, second – an accumulator function.

        // use stream, reduce - calculate sum

        // Collecting
        // The reduction can also be provided by the collect() method of type Stream.
        // This operation is very handy in case of converting a stream to a Collection or a Map and representing a stream in form of a single string.

        // use stream, Collectors - get bookmarks list with all titles uppercase

        List<String> resultList = recommendedItems
                .stream()
                .map(element -> element.getTitle().toUpperCase())
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
