package com.telerikacademy.agency.models.vehicles.contracts;

import com.telerikacademy.agency.models.enums.VehicleType;

public interface Vehicle {
    int getPassengerCapacity();

    double getPricePerKilometer();

    VehicleType getType();

    String toString();
}
