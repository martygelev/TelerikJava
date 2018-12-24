package com.telerikacademy.oop;

public class Staff extends User {
	public void printUserType() {
		super.printUserType();
		System.out.println("Staff");
	}
	
	public void postAReview() {
	   System.out.println("Staff: postAReview");
	}
}