package com.telerikacademy.oop1;

// Same package, a child class
public class C1 extends A1 {
	public static void main(String[] args) {
		//1. The private member is not accessible
		// System.out.println("privateMember: " + privateMember);

		//2. Inherited members are directly accessible
		System.out.println("defaultMember: " + defaultMember);
		System.out.println("protectedMember: " + protectedMember);
		System.out.println("publicMember: " + publicMember);
	}
}