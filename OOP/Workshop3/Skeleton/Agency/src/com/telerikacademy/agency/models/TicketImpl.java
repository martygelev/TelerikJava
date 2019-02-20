package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private Journey soldFor;
    private double administrativeCost;

    public TicketImpl(Journey soldFor, double administrativeCost) {
        setAdministrativeCost(administrativeCost);
        setSoldFor(soldFor);
    }

    private void setSoldFor(Journey soldFor) {
        this.soldFor = soldFor;
    }

    private void setAdministrativeCost(double administrativeCost) {
        this.administrativeCost = administrativeCost;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCost;
    }

    @Override
    public Journey getJourney() {
        return soldFor;
    }

    @Override
    public double CalculatePrice() {
        return soldFor.calculateTravelCosts() * this.getAdministrativeCosts();
    }

    @Override
    public String toString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f", getJourney().getDestination(), this.CalculatePrice());
    }
}
