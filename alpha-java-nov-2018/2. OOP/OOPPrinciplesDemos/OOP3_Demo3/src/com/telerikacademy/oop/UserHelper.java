package com.telerikacademy.oop;

public class UserHelper {
	
	public void printUserType(User u) {
	    u.printUserType();
	}

//	public Review postReview(User u){
//		return u.postAReview();
//	}

	// test casting
	public void approveReview(Staff s) {

		// call method that is from child class - compile error
//		s.approveReview();

		// explicit casting
//		((Editor) s).approveReview();

//		if (s instanceof Editor) {
//			((Editor) s).approveReview();
//        } else {
//        	System.out.println("Invalid object passed!!");
//        }
	}
}