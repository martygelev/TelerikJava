package com.telerikacademy.oop;

abstract class AbstractChildClass extends AbstractBaseClass {
	public AbstractChildClass(){
		System.out.println("Child abstract c-r");
	}

	@Override
    void test1() {
    	System.out.println("test1");
    }
	abstract void test3();

//	void instanceMethod() {
//		System.out.println("Instance method of abstract child class");
//	}
}
