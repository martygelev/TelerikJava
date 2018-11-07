package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> carsSet = new HashSet<>();

        String line = in.nextLine();
        while(!"END".equals(line))
        {
            String[] input = line.split(", ");
            String direction = input[0];
            String carNumber = input[1];

            if ("IN".equals(direction))
            {
                carsSet.add(carNumber);
            }
            else if ("OUT".equals(direction))
            {
                carsSet.remove(carNumber);
            }

            line = in.nextLine();
        }

        if (carsSet.isEmpty())
        {
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String s : carsSet) {
            System.out.println(s);
        }

    }
}