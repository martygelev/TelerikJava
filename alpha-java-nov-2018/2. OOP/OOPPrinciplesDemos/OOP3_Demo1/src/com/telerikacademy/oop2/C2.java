package com.telerikacademy.oop2;

import com.telerikacademy.oop1.A1;

// Not the same package, a child class
public class C2 extends A1 {
	public static void main(String[] args) {
		// The private & default members are not accessible
		// System.out.println("privateMember: " + privateMember);
		//System.out.println("defaultMember: " + defaultMember);

		System.out.println("protectedMember: " + protectedMember);
		System.out.println("publicMember: " + publicMember);
	}
}