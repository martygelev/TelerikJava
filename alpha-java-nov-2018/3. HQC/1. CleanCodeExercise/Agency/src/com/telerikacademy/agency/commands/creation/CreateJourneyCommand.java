package com.telerikacademy.agency.commands.creation;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

import java.util.List;

public class CreateJourneyCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public CreateJourneyCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        String startLocation;
        String destination;
        int distance;
        Vehicle vehicle;

        try {
            startLocation = parameters.get(0);
            destination = parameters.get(1);
            distance = Integer.parseInt(parameters.get(2));
            vehicle = engine.getVehicles().get(Integer.parseInt(parameters.get(3)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse CreateJourney command parameters.");
        }

        Journey journey = factory.createJourney(startLocation, destination, distance, vehicle);
        engine.getJourneys().add(journey);

        return String.format("Journey with ID %s was created.", engine.getJourneys().size() - 1);
    }
}
