package com.telerikacademy.ldstofillFromSession.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateLinkedListExample {
    public static void main(String[] args) {

        // Creating a LinkedList
        LinkedList<String> friends = new LinkedList<>();

        friends.add("Phoebe");
        friends.add("Rachel");
        friends.add("Joey");
        friends.add("Ross");
        friends.add("Monika");
        friends.add("Chandler");

        // Adding new elements to the end of the LinkedList using add() method.
        friends.addLast("Janice");

        System.out.println("Initial LinkedList : " + friends);

        // Adding an element at the specified position in the LinkedList
        friends.add(3, "Gunter");

        System.out.println("After add(3, \"Gunter\") : " + friends);

        // Adding an element at the beginning of the LinkedList using addFirst
        friends.addFirst("Mike");

        System.out.println("After addFirst(\"Mike\") : " + friends);

        // Adding an element at the end of the LinkedList (This method is equivalent to the add() method)

        //System.out.println("After addLast(\"Jennifer\") : " + friends);

        // Adding all the elements from an new existing collection to the end of the LinkedList
List<String> moreFriendsCast = new ArrayList<>();
        moreFriendsCast.add("Jack");
        moreFriendsCast.add("David");
        moreFriendsCast.add("Emma");

        friends.addAll(4, moreFriendsCast);
        System.out.println("After addAll(moreFriendsCast) : " + friends);
    }
}