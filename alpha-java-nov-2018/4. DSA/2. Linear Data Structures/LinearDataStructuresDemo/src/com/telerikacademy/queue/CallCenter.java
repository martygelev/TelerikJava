package com.telerikacademy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CallCenter {
    Queue<CustomerSupportRep> supportReps;
    Queue<Customer> customers;

    public CallCenter(Queue<CustomerSupportRep> queue) {
        this.supportReps = queue;
        customers = new LinkedList<>();
    }

    public void acceptCustomer(Customer customer) {
        customers.add(customer);
    }

    public void work() {
        CustomerSupportRep customerSupportRep = null;
        int waitingPeriod = 3;
        while ((supportReps.isEmpty()
                || (customerSupportRep = supportReps.poll()) == null)
                && waitingPeriod-- > 0) {
            playHoldMusic();
        }

        while (!customers.isEmpty() && customerSupportRep != null) {
            customerSupportRep.assist(customers.poll());
            supportReps.add(customerSupportRep);
        }
    }

    public void playHoldMusic() {
        System.out.println("Smooooooth Operator.....");
    }
}
