package com.telerikacademy.agency.core.factories;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.contracts.Ticket;
import com.telerikacademy.agency.models.vehicles.contracts.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AgencyFactoryImpl implements AgencyFactory {
    public AgencyFactoryImpl() {
    }

    public Bus createBus(int passengerCapacity, double pricePerKilometer) {
        throw new NotImplementedException();
    }

    public Airplane createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        throw new NotImplementedException();
    }

    public Train createTrain(int passengerCapacity, double pricePerKilometer, int carts) {
        throw new NotImplementedException();
    }

    public Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle) {
        throw new NotImplementedException();
    }

    public Ticket createTicket(Journey journey, double administrativeCosts) {
        throw new NotImplementedException();
    }
}
