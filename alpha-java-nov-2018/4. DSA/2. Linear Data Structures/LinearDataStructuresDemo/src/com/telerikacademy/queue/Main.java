package com.telerikacademy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<CustomerSupportRep> queueSupportReps = new LinkedList<>();

        CallCenter callCenter = new CallCenter(queueSupportReps);

        callCenter.acceptCustomer(new Customer("Nadya"));
        callCenter.acceptCustomer(new Customer("Polya"));

        callCenter.work();

        queueSupportReps.add(new CustomerSupportRep("Ivan"));
        queueSupportReps.add(new CustomerSupportRep("Petkan"));

        callCenter.work();

        callCenter.acceptCustomer(new Customer("Jelyo"));
        callCenter.acceptCustomer(new Customer("Kolyo"));

        callCenter.work();
    }
}
