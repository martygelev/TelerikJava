package com.telerikacademy.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainFull {

    public static void main(String[] args) {
        // 1. write the following anonymous class as a Lambda expression
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };


//        // 1. Solution
//        Runnable runnable1 = () -> {
//            String myString = "Let's split this up into an array";
//            String[] parts = myString.split(" ");
//            for (String part : parts) {
//                System.out.println(part);
//            }
//        };


        // 2. Solution
//        Function<String, String> lambdaSecondChar = s -> {
//            StringBuilder returnVal = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (i % 2 == 1) {
//                    returnVal.append(s.charAt(i));
//                }
//            }
//
//            return returnVal.toString();
//        };

        // 3. Using the function from task 2, write code that will execute it with argument "1234567890"
        // 3. Solution
        //System.out.println(lambdaSecondChar.apply("1234567890"));

        // 4. instead of executing lambdaSecondChar directly, suppose we want to pass it to a method. Write a method
        // called everySecondCharacter that accepts the function as a parameter and execute it with the argument "1234567890".
        // It should return the result of the function. For bonus points don't hardcode the argument string within the method.

        // 5. Using the new version of the method call it with argument "1234567890" and print the result
        // 5.Solution
//        String result = everySecondCharacter(lambdaSecondChar, "1234567890");
//        System.out.println(result);

        // 6. Write a lambda expression that maps to the java.util.Supplier interface.
        // This lambda should return the string "I love Java" and assign it to a variable called iLoveJava
        // Use the supplier to get its result in supplierResult variable, then print it on the screen
        //6. Solution
//        Supplier<String> iLoveJava = () -> "I love Java!";
//        Supplier<String> iLoveJava = () -> { return "I love Java!"; };
//        String supplierResult = iLoveJava.get();
//        System.out.println(supplierResult);

        // 7. There are many interfaces in the Java SDK and sometimes we can use a lambda expression
        // instead of creating an instance that implements the interface that we want to use.
        //
        // Given a specific interface how can we tell whether we can map a lambda expression to it.
        // What's the criteria that has to be met?

        // 7. Solution
        // The interface has to be a functional interface. It can have only a single method that must be implemented.
        // A functional interface can contain more than one method, but all the methods but one must have default implementations.
        // Most of the time the documentation will state whether it's a functional interface.

        //8. Can we use a lambda expression to represent an instance of java.util.concurrent.Callable interface?
        // HINT: You'll have to read the documentation. As a java developer you have to be familiar with it.
        // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable.html

        // 8. Solution
        // The Callable interface has only one method that has to be implemented - the call() method.
        // So we can use a lambda for it. The documentation also states that it is a functional interface.

        // 9. Is the java.util.Comparator a functional interface?

        // 9. Solution
        // Yes, it is. Despite containing more than 10 methods, it has only one that needs an implementation - compare().
        // https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

        // 10. We have list with top female names for 2018.
        // Write code to print the items in the list in sorted order, and with the first letter in each upper-cased.
        // Use lambda expression when possible.
        // 10.1 Re-work the solution to use method references where ever possible.
        // 10.2 Use streams for the same solution

        List<String> femaleNames = Arrays.asList(
                "Olivia",
                "Sophia",
                "amelia",
                "lily",
                "emily",
                "Ava",
                "Isla",
                "Aria",
                "mia",
                "Isabella"
        );

        // 10.Solution
        Stream<String> result = femaleNames.stream()
                .sorted(String::compareToIgnoreCase)
                .map(MainFull::capitalizeCase);
//        result.forEach(System.out::println);

        // 11. Print how many names start with letter 'A'
        // HINT1: You'll have to modify the stream chain
        // HINT2: You'll have to add another statement to print the number of items
        Stream<String> filteredResult = result.filter(s->s.startsWith("A"));
        System.out.println(filteredResult.count());

        // 12. Homework: Research peek() operation on streams. How to make it work in case we want to see if capitalizeCase is working correctly?
    }

    // 2. write the following method as a lambda expression.
    // HINT: use Function<>
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    //10. Solution
    public static String capitalizeCase(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }


    // 4. Solution
//    public static String everySecondCharacter(Function<String, String> func, String source) {
//        return func.apply(source);
//    }
}












