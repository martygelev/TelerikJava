package com.telerikacademy.oop;

abstract class AbstractBaseClass {
    public AbstractBaseClass(){
        System.out.println("Base abstract c-r");
    }

    abstract void test1();

    abstract void test2();

    void instanceMethod() {
        System.out.println("Instance method of base class");
    }
}
