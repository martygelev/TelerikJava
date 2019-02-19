# Exceptions Practice

## Tasks

### Task 1
1. Create a class with a **main( )** that throws an object of class **Throwable** inside a **try** block.
2. Give the constructor for **Throwable** a **String** argument.
3. Catch the exception inside a **catch** clause and print the **String** argument.
4. Add a **finally** clause and print a message to prove you were there.

### Task 2
1. Create your own exception class using the **extends** keyword.
2. Write a constructor for this class that takes a **String** argument and stores it inside the object with a **String** reference.
3. Write a method that prints out the stored String. Create a **try-catch** clause to exercise your new exception.

### Task 3
1. Write a class with a method that throws an exception of the type created in Task 2.
2. Try compiling it without an exception specification to see what the compiler says.
3. Add the appropriate exception specification.
4. Try out your class and its exception inside a try-catch clause.

### Task 4
1. Define an object reference and initialize it to **null**.
2. Try to call a method through this reference.
3. Now wrap the code in a **try-catch** clause to catch the exception.

### Task 5
1. Create a class with two methods, f( ) and g( ).
2. In **g( )**, throw an exception of a new type that you define.
3. In **f( )**, call **g( )**, catch its exception and, in the **catch** clause, throw a different exception (of a second type that you define) wrapped in **RuntimeException**.
4. Test your code in **main( )**.

### Task 6
1. Create three new types of exceptions.
2. Write a class with a method that throws all three.
3. In **main( )**, call the method but only use a single **catch** clause that will catch all three types of exceptions.

### Task 7
1. Write code to generate and catch an **ArrayIndexOutOfBoundsException**.

### Task 8
1. Create a three-level hierarchy of exceptions.
2. Now create a base-class **A** with a method that throws an exception at the base of your hierarchy.
3. Inherit **B** from **A** and override the method so it throws an exception at level two of your hierarchy.
4. Repeat by inheriting class **C** from **B**.
5. In **main( )**, create a **C** and upcast it to **A**, then call the method.

### Task 9
1. Modify Таск 6 by adding a **finally** clause.
2. Verify that your **finally** clause is executed, even if a **NullPointerException** is thrown.