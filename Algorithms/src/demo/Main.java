package demo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int numberOfIterations;
    static int elements;
    static int[] combination;

    public static void main(String[] args) {

        elements = 2;
        numberOfIterations = 4;

        combination = new int[elements];
        iteration(0, combination, elements);


    }

    public static void iteration(int currentIndex, int[] combination, int elements) {
        if (currentIndex == elements) {
            for (Integer integer : combination) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }
        for (int i = currentIndex + 1; i <= numberOfIterations; i++) {
            combination[currentIndex] = i;
            iteration(currentIndex + 1, combination, elements);


        }
    }


}
