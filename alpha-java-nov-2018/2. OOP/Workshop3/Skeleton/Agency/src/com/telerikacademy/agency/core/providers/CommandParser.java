package com.telerikacademy.agency.core.providers;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.commands.creation.*;
import com.telerikacademy.agency.commands.listing.ListJourneysCommand;
import com.telerikacademy.agency.commands.listing.ListTicketsCommand;
import com.telerikacademy.agency.commands.listing.ListVehiclesCommand;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.contracts.Parser;
import com.telerikacademy.agency.core.factories.AgencyFactory;

import java.util.*;

public class CommandParser implements Parser {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    private final AgencyFactory factory;
    private final Engine engine;

    public CommandParser(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public Command parseCommand(String fullCommand) {
        String commandName = fullCommand.split(" ")[0];
        return findCommand(commandName);
    }

    public List<String> parseParameters(String fullCommand) {
        String[] commandParts = fullCommand.split(" ");
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }

    private Command findCommand(String commandName) {
        switch (commandName.toLowerCase()) {
            case "createairplane":
                return new CreateAirplaneCommand(factory, engine);

            case "createbus":
                return new CreateBusCommand(factory, engine);

            case "createjourney":
                return new CreateJourneyCommand(factory, engine);

            case "createticket":
                return new CreateTicketCommand(factory, engine);

            case "createtrain":
                return new CreateTrainCommand(factory, engine);

            case "listjourneys":
                return new ListJourneysCommand(factory, engine);

            case "listtickets":
                return new ListTicketsCommand(factory, engine);

            case "listvehicles":
                return new ListVehiclesCommand(factory, engine);
        }
        throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandName));
    }
}
