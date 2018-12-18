package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.vehicles.contracts.Train;

import java.util.List;

public class CreateTrainCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateTrainCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    @Override
    public String execute(List<String> parameters) {
        int passengerCapacity;
        double pricePerKilometer;
        int cartsCount;

        try {
            passengerCapacity = Integer.parseInt(parameters.get(0));
            pricePerKilometer = Double.parseDouble(parameters.get(1));
            cartsCount = Integer.parseInt(parameters.get(2));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreateTrain command parameters.");
        }

        Train train = factory.createTrain(passengerCapacity, pricePerKilometer, cartsCount);
        engine.getVehicles().add(train);

        return String.format("Vehicle with ID %d was created.", engine.getVehicles().size() - 1);
    }
}
