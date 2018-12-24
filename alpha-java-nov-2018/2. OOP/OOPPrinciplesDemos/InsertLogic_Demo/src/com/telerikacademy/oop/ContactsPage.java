package com.telerikacademy.oop;

public class ContactsPage extends Page {
    String address;

    public ContactsPage(String address) {
        this.address = address;
    }

    // Every page MUST have content - implement the renderContent abstract method
    @Override
    public void renderContent() {
        System.out.println("You can find us on address ");
        System.out.println(address);
        System.out.println("Welcome!");
    }

    //Contacts page contains address that should be printed  - override the print method & reuse its base functionality
    public String print() {
        StringBuilder sb = new StringBuilder(super.print());
        sb.append(System.lineSeparator());
        sb.append("Address: " + address);
        return sb.toString();
    }

}
