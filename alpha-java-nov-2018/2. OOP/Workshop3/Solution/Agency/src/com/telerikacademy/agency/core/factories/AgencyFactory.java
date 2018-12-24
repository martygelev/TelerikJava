package com.telerikacademy.agency.core.factories;

import com.telerikacademy.agency.models.contracts.*;
import com.telerikacademy.agency.models.vehicles.contracts.*;

public interface AgencyFactory {
    Bus createBus(int passengerCapacity, double pricePerKilometer);

    Train createTrain(int passengerCapacity, double pricePerKilometer, int carts);

    Airplane createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood);

    Journey createJourney(String startingLocation, String destination, int distance, Vehicle vehicle);

    Ticket createTicket(Journey journey, double administrativeCosts);
}
