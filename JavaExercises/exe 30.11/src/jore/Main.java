package jore;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(", ");
        int[] terrain = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            terrain[i] = Integer.parseInt(input[i]);
        }

        int result = 0;

        for (int start = 0; start < terrain.length; start++) {
            for (int step = 1; step < terrain.length; step++) {
                int currentPosition = start;
                int jumpCells = 1;
                int nextCell = (currentPosition + step) % terrain.length;

                while (terrain[currentPosition] < terrain[nextCell] && nextCell != start) {
                    jumpCells++;
                    currentPosition = nextCell;
                    nextCell = (currentPosition + step) % terrain.length;
                }

                if (jumpCells > result) {
                    result = jumpCells;
                }
            }
        }
        System.out.println(result);
    }
}