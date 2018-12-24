package com.telerikacademy.oop;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Staff staff = new Staff();
        Editor editor = new Editor();
        UserHelper helper = new UserHelper();

        // 1. test overriding
        // 2. test the super keyword & endless recursion
        // Review review = user.postAReview("Test text");
        // System.out.println(review.isApproved());
        // staff.postAReview("Test text 1");
        // System.out.println(review.isApproved());

        // test hiding fields
        // ((Staff) staff).printId();

        // Casting & instanceof demo
          // run time error
//        Review review = helper.approveReview(new Staff());
//        System.out.println(review.isApproved());
//        Review review = helper.approveReview(new Editor());
//
//       ArrayList<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(editor);
//        users.add(staff);
//        for (User u : users){
//            Review review = helper.postReview(u, "fsdf");
//            System.out.println(review.isApproved());
//            System.out.println(System.lineSeparator());
//        }

        //testing hidden methods
        // staff.staticMethod(); //static method is bind in compile time, so the compiler decides this is User's method
    }
}
