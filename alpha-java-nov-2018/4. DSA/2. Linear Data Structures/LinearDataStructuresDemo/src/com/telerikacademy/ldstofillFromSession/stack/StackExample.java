package com.telerikacademy.ldstofillFromSession.stack;

import java.util.Stack;

class NadyaStack extends Stack<String> {
    public String toString() {
        NadyaStack temp = new NadyaStack();
        temp.addAll(this);
        String result = "";
        int originalSize = size();
        for (int i = 0; i < originalSize; i++) {
            String top = pop();
            result += top + " ";
        }
        this.addAll(temp);
        return result;
    }

    public String pop() {
        System.out.println("Popped!");
        return super.pop();
    }
}

public class StackExample {
    public static void main(String[] args) {
        // Creating a Stack stackOfCards
        Stack<String> stackOfCards = new Stack<>();
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Jack");
        stackOfCards.push("Ace");

//         System.out.println("Stack => " + stackOfCards + stackOfCards.size());
//         System.out.println();
//        System.out.println("Stack after first print => " + stackOfCards + stackOfCards.size());

        // Popping items from the Stack
        // Throws EmptyStackException if the stack is empty

//        System.out.println("Stack.pop() => " + cardAtTop);
//        System.out.println("Current Stack => " + stackOfCards);
//        System.out.println();

        // Get the item at the top of the stack without removing it
        String cardAtTop = stackOfCards.pop();
        System.out.println("Current Stack after pop of => " + cardAtTop + " " + stackOfCards);
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);

    }
}
