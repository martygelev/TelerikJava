package com.telerikacademy.agency.commands.listing;
import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListVehiclesCommand  implements Command {

    private final AgencyFactory factory;
    private final Engine engine;

    public ListVehiclesCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    @Override
    public String execute(List<String> parameters) {
        List<Vehicle> vehicles = engine.getVehicles();

        if (vehicles.size() == 0) {
            return "There are no registered vehicles.";
        }

        return String.join("\n####################\n", vehicles.stream().map(Vehicle::toString).toArray(String[]::new));
    }

}
