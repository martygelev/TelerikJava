package com.telerikacademy.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Page> pages = new ArrayList<>();
        pages.add(new NewsPage());
        pages.add(new ContactsPage("Alexander Malinov 31, 1729"));

        for (Page p : pages){
            p.render();
            System.out.println("----------------------");
        }
    }
}
