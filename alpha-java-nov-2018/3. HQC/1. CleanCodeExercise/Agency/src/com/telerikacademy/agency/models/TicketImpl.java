package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private Journey journey;
    private double administrativeCosts;
    private double ticketPrice;

    public TicketImpl(Journey journey, double administrativeCosts) {
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
        setTicketPrice();
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    protected void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    protected void setAdministrativeCosts(double administrativeCosts) {
        this.administrativeCosts = administrativeCosts;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    protected void setTicketPrice() {
        this.ticketPrice = getAdministrativeCosts() * journey.getTravelCost();
    }

    public String print() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f", journey.getDestination(), getTicketPrice());
    }
}
