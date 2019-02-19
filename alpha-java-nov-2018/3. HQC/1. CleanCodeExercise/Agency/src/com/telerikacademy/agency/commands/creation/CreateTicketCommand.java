package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.List;

public class CreateTicketCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateTicketCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        Journey journey;
        double administrativeCosts;

        try {
            journey = engine.getJourneys().get(Integer.parseInt(parameters.get(0)));
            administrativeCosts = Double.parseDouble(parameters.get(1));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreateTicket command parameters.");
        }

        Ticket ticket = factory.createTicket(journey, administrativeCosts);
        engine.getTickets().add(ticket);

        return String.format("Ticket with ID %s was created.", engine.getTickets().size() - 1);
    }
}
