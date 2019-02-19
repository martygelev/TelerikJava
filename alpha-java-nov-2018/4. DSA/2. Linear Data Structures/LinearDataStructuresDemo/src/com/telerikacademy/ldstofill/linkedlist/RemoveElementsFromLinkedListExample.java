package com.telerikacademy.ldstofill.linkedlist;

import java.util.LinkedList;

public class RemoveElementsFromLinkedListExample {
    public static void main(String[] args) {

        // Create LinkedList with programing languages
        LinkedList<String> programmingLanguages = new LinkedList<>();

        programmingLanguages.add("Assembly");
        programmingLanguages.add("Fortran");
        programmingLanguages.add("Pascal");
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("C#");
        programmingLanguages.add("Kotlin");

        // Remove the first element in the LinkedList
        //  method removeFirst Throws NoSuchElementException if the LinkedList is empty

        // System.out.println("Removed the first element " + element + " => " + programmingLanguages);

        // Remove the last element in the LinkedList
        // Throws NoSuchElementException if the LinkedList is empty

        // System.out.println("Removed the last element " + element + " => " + programmingLanguages);

        // Remove the first occurrence of the specified element from the LinkedList
        // removed returns whether the element is removed

        //System.out.println("Removed C# => " + programmingLanguages);

        // Remove all the elements that satisfy the given predicate - removeIf

        //System.out.println("Removed elements starting with C => " + programmingLanguages);

        // Clear the LinkedList by removing all elements

        //System.out.println("Cleared the LinkedList => " + programmingLanguages);
    }
}
