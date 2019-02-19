package com.telerikacademy.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookmarkListFactory {

    public static List<Bookmark> getBookmarkList() {
        List<Bookmark> recommendedItems = new ArrayList<Bookmark>();

        // Create bookmarks and cache them
        Bookmark item1 = new Bookmark();
        item1.setId(2000);
        item1.setRating(4.0);
        item1.setTitle("Use Final Liberally");
        item1.setReviews(Arrays.asList(
                new Review(1, "Very nice", "Nadya", true),
                new Review(1, "description", "Math", true),
                new Review(1, "some text", "Sasho", false)
        ));

        Bookmark item2 = new Bookmark();
        item2.setId(2001);
        item2.setRating(4.5);
        item2.setTitle("How do I import a pre-existing Java project into Eclipse and get up and running?");
        item2.setReviews(Arrays.asList(
                new Review(1, "Nice", "Olivia", true),
                new Review(1, "cool", "Math", false)
        ));

        Bookmark item3 = new Bookmark();
        item3.setId(2002);
        item3.setRating(5.0);
        item3.setTitle("Interface vs Abstract Class");
        item3.setReviews(Arrays.asList(
                new Review(1, "bla", "Ava", true),
                new Review(1, "hello", "Masha", false),
                new Review(1, "text", "The Bear", false)
        ));

        Bookmark item4 = new Bookmark();
        item4.setId(2003);
        item4.setRating(4.0);
        item4.setTitle("NIO tutorial by Greg Travis");

        Bookmark item5 = new Bookmark();
        item5.setId(2004);
        item5.setRating(3.5);
        item5.setTitle("Virtual Hosting and Tomcat");

        Bookmark item6 = new Bookmark();
        item5.setId(2012);
        item5.setRating(5.0);
        item5.setTitle("Effective Java");

        recommendedItems.add(item1);
        recommendedItems.add(item2);
        recommendedItems.add(item3);
        recommendedItems.add(item4);
        recommendedItems.add(item5);

        return recommendedItems;
    }
}
