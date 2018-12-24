package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(Journey journey, double administrativeCosts) {
        this.journey = journey;
        this.administrativeCosts = administrativeCosts;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * getJourney().calculateTravelCosts();
    }

    @Override
    public String print() {
        return String.format("Ticket ----" + System.lineSeparator() +
                "Destination: %s" + System.lineSeparator() +
                "Price: %.2f" + System.lineSeparator(), getJourney().getDestination(), calculatePrice());
    }

    @Override
    public String toString() {
        return print();
    }
}
