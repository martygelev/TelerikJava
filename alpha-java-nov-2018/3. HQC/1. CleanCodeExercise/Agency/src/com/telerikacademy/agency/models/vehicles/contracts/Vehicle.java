package com.telerikacademy.agency.models.vehicles.contracts;

import com.telerikacademy.agency.models.common.VehicleType;

public interface Vehicle {

    int getPassengerCapacity();

    double getPricePerKilometer();

    VehicleType getVehicleType();

    String print();

}
