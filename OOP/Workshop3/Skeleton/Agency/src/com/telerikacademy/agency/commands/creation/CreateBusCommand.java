package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.vehicles.contracts.Bus;

import java.util.List;

public class CreateBusCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateBusCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    @Override
    public String execute(List<String> parameters) {
        int passengerCapacity;
        double pricePerKilometer;

        try {
            passengerCapacity = Integer.parseInt(parameters.get(0));
            pricePerKilometer = Double.parseDouble(parameters.get(1));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreateBus command parameters.");
        }

        Bus bus = factory.createBus(passengerCapacity, pricePerKilometer);
        engine.getVehicles().add(bus);

        return String.format("Vehicle with ID %d was created.", engine.getVehicles().size() - 1);
    }
}
