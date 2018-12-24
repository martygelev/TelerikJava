package com.telerikacademy.oop;

public class Staff extends User {
    // hiding field from super class
    public int id = 2;

    public void printId() {
        System.out.println("id: " + id);
        System.out.println("super.id: " + super.id);

        Staff.staticMethod();
        User.staticMethod();
    }

    public void printUserType() {
        System.out.println("Staff");
    }

    // test that super cannot be called in static method
    // test method hiding
    public static void staticMethod(){
        System.out.println("Staff: static method");
    }

    //    public Review postAReview(String reviewText) {
//        System.out.println("Staff: postAReview");
//        return new Review(review);
//    }

//    public Review postAReview(String reviewText) {
//        System.out.println("Staff: postAReview");

//        // if you do not use super, you'll fall into endless recursion
//        Review review = super.postAReview(reviewText);
//        review.setApproved(true);
//        return review;
//    }
}