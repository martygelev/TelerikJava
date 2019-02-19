package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Ticket;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.Arrays;
import java.util.List;

public class ListVehiclesCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public ListVehiclesCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        List<Vehicle> vehicles = engine.getVehicles();

        if (vehicles.size() == 0) {
            return "There are no registered vehicles.";
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < vehicles.size(); i++) {
            sb.append(vehicles.get(i).print());
            if (i < vehicles.size() - 1) {
                sb.append("\n####################\n");
            }
        }
        return sb.toString();
    }
}
