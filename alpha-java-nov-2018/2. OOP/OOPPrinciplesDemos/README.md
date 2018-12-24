# OOP Principles Demos Walk Trough

## OOP Principles Part 1

### Demo 1

#### Access Modifiers & Inheritance

We have two packages that have classes in them. We have simple inheritance structure & will test out how the modifiers impact the access on these classes' members.

Classes A1, B1, C1 are in same package and B2 & C2 are in the other one. 

Class A1 is the base class of C1 & C2. Classes B1 & B2 do not extend any class, but access members of other classes.

Try out all members across classes - for example start with accessing A1's private member in C1, B1, C2 & B2 classes.

### Demo 2

#### Constructors & Inheritance

*Note:* We are going to use the class hierarchy we created in the Coding Challenge 1 - the HMS.

Create default constructors & see how they're invoked.
Create constructors with parameters and see how they're called.

We added Main method for testing purposes.

### Demo 3

#### Polymorphism

We have three classes as we had in the presentation. User is the base class, Staff extends it & Editor extends Staff. We also have Main class for testing purposes.

There is one more class - UserPrint. This is a utility class that has one method that accepts User and calls its printUserType method.

### Demo 4

#### Method Overriding

See the code and review the overriding rules. Start with the second one. Take one public method from the base class and try to override it with private access modifier. You should see a compiler error.

To test the second rule we need one more class - the Review class. It will represent book or movie review, so it will have two properties reviewText and approved. As we know every review that is not written by the Staff should be approved.

Now, if we change the postAReview method to take review text, create new Review and return it, in order to override this method in Staff class, we change its parameters. This way it has same signature, but as the compiler says, incompatible return types.

Using **super** keyword we call base class's method's implementation. In this particular case we are extending the base class's method logic (approve the review), so it is better to call the base class implementation, to avoid redundant code.

Skipping the super keyword leads to runtime error and endless recursion. Also let's test that we cannot call super from a static method.

#### Hidden Fields

We have fields with same names in both base and child classes. Test out what is called when.

#### Casting & instanceof operator

We try several things:

* Call method that is from child class - compile error.

* Explicit cast & incompatible object type

* Add instanceof and have safe code

#### Method Hiding

If we have static method in our base class and static method with same signature in the child class - this is method hiding. Static methods are not overridden.

## OOP Principles Part 2

### Demo 1

#### Abstract classes & methods

We have three classes here one abstract base class and two derived classes - one is abstract and other is concrete & inherits the abstract child class.

The abstract child class is overriding only one of the two abstract classes and defines in its turn abstract class.

The concrete class needs to implement all abstract methods that are not implemented through the inheritance tree. In its main method all three methods are called. See what implementation is called in every case.

Test instantiating the abstract base class.
Test not implementing some of the abstract methods.
Test that overriding instance methods works as usual.

### Demo 2

#### Interfaces

We have class hierarchy you see in the presentation. Interface A with methods foo & bar - modifiers are needed, they are implicitly public.

AbstractA is an abstract class that implements interface A and implements only one (bar()) of its methods.

Class X is a concrete class that extends AbstractA and implements interface A.

Test that we need to provide implementation for the unimplemented method of A - foo();

In the main method we can test:

* Instantiate the interface A - compile error

Now define foo() method in interface B & let X implements B as well. Test that there is no issue with that class implements two interfaces that have same methods.

Test that all variable should be constant - try to add filed that is not initialized - compile error.

Initialize it & test that X class is printing the value from the interface A.

Now test clash of field names - add same field in interface B and see what happens when trying to print it in X - compile error. It is necessary to explicitly state which interface's field you'd like to use.

Test that the constant can be initialized by method call.

Interface C is extending interface A and has its own method foobar(). Now let X implement C as well - test that X needs to implement foobar only now.