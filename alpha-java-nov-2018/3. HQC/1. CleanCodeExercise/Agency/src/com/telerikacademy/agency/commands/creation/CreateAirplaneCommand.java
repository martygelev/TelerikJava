package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Airplane;

import java.util.List;

public class CreateAirplaneCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateAirplaneCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        int passengerCapacity;
        double pricePerKilometer;
        boolean hasFreeFood;

        try {
            passengerCapacity = Integer.parseInt(parameters.get(0));
            pricePerKilometer = Double.parseDouble(parameters.get(1));
            hasFreeFood = Boolean.parseBoolean(parameters.get(2));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreateAirplane command parameters.");
        }

        Airplane airplane = factory.createAirplane(passengerCapacity, pricePerKilometer, hasFreeFood);
        //airplane.setVehicleType(VehicleType.AIR);
        engine.getVehicles().add(airplane);

        return String.format("Vehicle with ID %d was created.", engine.getVehicles().size() - 1);
    }
}
