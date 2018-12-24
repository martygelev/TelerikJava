package com.telerikacademy.oop;

public class NewsPage extends Page{

    // Every page MUST have content - implement the renderContent abstract method
    @Override
    public void renderContent() {
        System.out.println("News list here");
    }

    //News page contains list of new titles and is pointless to print additional things. Hence no override of print method.
}
