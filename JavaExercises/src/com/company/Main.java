package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        Set<String> guestList = new TreeSet<>();


        while(!"PARTY".equals(line))
        {
            guestList.add(line);
            line = in.nextLine();
        }
        line = in.nextLine();

        while(!"END".equals(line))
        {
            guestList.remove(line);
            line = in.nextLine();
        }

        System.out.println(guestList.size());
        for (String s : guestList) {
            System.out.println(s);
        }
    }
}
