package com.telerikacademy.agency.core;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.*;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.core.providers.*;
import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {
    private static final String TERMINATION_COMMAND = "Exit";

    private Reader reader;
    private Writer writer;
    private Parser parser;
    private final List<Vehicle> vehicles;
    private final List<Journey> journeys;
    private final List<Ticket> tickets;

    public EngineImpl(AgencyFactory factory) {
        reader = new ConsoleReader();
        writer = new ConsoleWriter();
        parser = new CommandParser(factory, this);

        vehicles = new ArrayList<>();
        journeys = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public List<Journey> getJourneys() {
        return journeys;
    }

    @Override
    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public void start() {
        while (true) {
            try {
                String commandAsString = reader.readLine();
                if (commandAsString.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(commandAsString);
            } catch (Exception ex) {
                writer.writeLine(ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString());
            }
        }
    }

    private void processCommand(String commandAsString) {
        if (commandAsString == null || commandAsString.trim().equals("")) {
            throw new IllegalArgumentException("Command cannot be null or empty.");
        }
        Command command = parser.parseCommand(commandAsString);
        List<String> parameters = parser.parseParameters(commandAsString);
        String executionResult = command.execute(parameters);
        writer.writeLine(executionResult);
    }
}
