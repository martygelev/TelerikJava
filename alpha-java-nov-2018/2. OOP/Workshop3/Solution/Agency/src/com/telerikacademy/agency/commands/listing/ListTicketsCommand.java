package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Ticket;

import java.util.ArrayList;
import java.util.List;

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
            return "There are no registered tickets.";
        }

        List<String> listTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            listTickets.add(ticket.toString());
        }

        return String.join("####################" + System.lineSeparator(), listTickets).trim();
    }
}
