package com.telerikacademy.oop;

public abstract class Page {
    private void renderHeader() {
        System.out.println("Header: Logo & Menu Items here");
    }

    private void renderFooter() {
        System.out.println("Footer: Website map & links here");
    }

    public abstract void renderContent();

    public void render() {
        renderHeader();
        renderContent();
        renderFooter();
    }

    public String print() {
        return "Printing page ----";
    }

}