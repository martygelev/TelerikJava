package com.telerikacademy.oop2;

import com.telerikacademy.oop1.A1;
import com.telerikacademy.oop1.C1;

// Not the same package, not a child class
public class B2 {
	public static void main(String[] args) {
		// The private & default members are not accessible
		//System.out.println("A1.privateMember: " + A1.privateMember);
		// System.out.println("A1.defaultMember: " + C1.defaultMember);

		// The protected member cannot be accessed by classes in other packages
		//System.out.println("A1.protectedMember: " + A1.protectedMember);
		//System.out.println("C2.protectedMember: " + C2.protectedMember);
		
		System.out.println("A1.publicMember: " + A1.publicMember);
		System.out.println("C2.publicMember: " + C2.publicMember);
	}
}
