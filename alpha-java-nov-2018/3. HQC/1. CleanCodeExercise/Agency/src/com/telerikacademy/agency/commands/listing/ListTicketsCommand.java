package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Ticket;

import java.util.Arrays;
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

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < tickets.size(); i++) {
            sb.append(tickets.get(i).print());
            if (i < tickets.size() - 1) {
                sb.append("\n####################\n");
            }
        }
        return sb.toString();
    }
}
