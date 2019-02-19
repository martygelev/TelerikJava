package com.telerikacademy.models;

import com.sun.jndi.toolkit.url.Uri;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Bookmark {
    private long id;
    private String title;
    private double rating;
    private boolean isPopular = false;
    private List<Review> reviews = new ArrayList<>();

    public List<Review> getReviews() {
        return new ArrayList<>(reviews);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean popular) {
        isPopular = popular;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addToFavourites(){
        System.out.println("Added to favourites!");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(getRating());
        sb.append(" ");
        sb.append(getTitle());
        sb.append(" ");
        if (isPopular()) {
            sb.append("Popular ");
        }
        return sb.toString();
    }
}
