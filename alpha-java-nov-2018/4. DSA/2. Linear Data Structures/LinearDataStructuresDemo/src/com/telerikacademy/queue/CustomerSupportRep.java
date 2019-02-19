package com.telerikacademy.queue;

import java.util.ArrayList;
import java.util.List;

public class CustomerSupportRep {
    private String name;
    private List<Customer> assistedCustomers;

    public CustomerSupportRep(String name) {
        this.name = name;
        assistedCustomers = new ArrayList<>();
    }

    public void assist(Customer customer) {
        System.out.printf("Hello %s, my name is %s, how can I assist you.%n",
                customer.getName(),
                name);
        System.out.println("...");

        System.out.println("Is there anything else I can help you with?");
        System.out.println(System.lineSeparator());
        assistedCustomers.add(customer);
    }

    public List<Customer> getAssistedCustomers() {
        return new ArrayList<>(assistedCustomers);
    }
}
