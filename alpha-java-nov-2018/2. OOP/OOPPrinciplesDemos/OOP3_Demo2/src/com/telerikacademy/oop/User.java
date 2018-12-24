package com.telerikacademy.oop;

public class User {
   public void printUserType() {
	   System.out.println("User");
   }
   
   public void saveWebLink() {
	   System.out.println("User: saveWebLink");
	   postAReview();
   }
   public void postAReview() {
	   System.out.println("User: postAReview");
   }
}