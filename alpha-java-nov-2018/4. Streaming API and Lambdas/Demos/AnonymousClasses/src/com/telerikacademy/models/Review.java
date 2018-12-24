package com.telerikacademy.models;

public class Review {
    private int id;
    private String description;
    private String author;
    private boolean isApproved;

    public Review(int id, String description, String author, boolean isApproved) {
        this.id = id;
        this.description = description;
        this.author = author;
        this.isApproved = isApproved;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\t");
        sb.append(getAuthor());
        sb.append(" ");
        sb.append(getDescription());
        sb.append(" ");
        if (isApproved()) {
            sb.append("Approved! ");
        }
        else {
            sb.append("Waiting for approval!");
        }
        return sb.toString();
    }
}
