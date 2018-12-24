package com.telerikacademy.oop;

public class ConcreteChildClass extends AbstractChildClass {
    public ConcreteChildClass(){
        System.out.println("Concrete child c-r");
    }

   @Override
   void test2() {
	   System.out.println("test2");
   }
   @Override
   void test3() {
	   System.out.println("test3");
   }

//    void instanceMethod() {
//        System.out.println("Instance method of concrete child class");
//}

   public static void main(String[] args) {
	   ConcreteChildClass concrete = new ConcreteChildClass();
	   concrete.test1();
	   concrete.test2();
	   concrete.test3();
	   concrete.instanceMethod();
	   // AbstractBaseClass test = new AbstractBaseClass();
   }
}
