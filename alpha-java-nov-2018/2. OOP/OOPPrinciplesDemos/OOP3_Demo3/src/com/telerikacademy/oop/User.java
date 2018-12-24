package com.telerikacademy.oop;

public class User {
    public int id = 1;

    // test method hiding
    public static void staticMethod() {
        System.out.println("User: static method");
    }

    public void printUserType() {
        System.out.println("User");
    }

    public void saveWebLink() {
        System.out.println("User: saveWebLink");
        //postAReview();
    }

    public void postAReview() {
        System.out.println("User: postAReview");
    }

//    public Review postAReview(String reviewText) {
//        System.out.println("User: postAReview");
//        Review review = new Review(reviewText);
//        return review;
//    }
}