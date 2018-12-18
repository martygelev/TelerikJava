package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;

import java.util.List;

public class CreateTicketCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateTicketCommand(AgencyFactory factory, Engine engine)
    {
        this.factory=factory;
        this.engine=engine;
    }

    @Override
    public String execute(List<String> parameters) {
        Journey id;
        double administrativeCost;

        try{
            id= engine.getJourneys().get(Integer.parseInt(parameters.get(0)));
            administrativeCost=Double.parseDouble(parameters.get(1));
        }

        catch (Exception exp)
        {
            throw new IllegalArgumentException("Failed to parse CreateTicket command parameters.");
        }

        Ticket ticket = factory.createTicket(id,administrativeCost);
        engine.getTickets().add(ticket);

        return String.format("Ticket with ID %d was created.",engine.getTickets().size()-1);

    }
}
