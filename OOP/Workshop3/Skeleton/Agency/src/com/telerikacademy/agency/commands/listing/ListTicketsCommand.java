package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Ticket;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListTicketsCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public ListTicketsCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        List<Ticket> tickets = engine.getTickets();

        if (tickets.size() == 0) {
            return "Failed to parse CreateTicket command parameters.";
        }

        return String.join("\n####################\n", tickets.stream().map(Ticket::toString).toArray(String[]::new));
    }
}
