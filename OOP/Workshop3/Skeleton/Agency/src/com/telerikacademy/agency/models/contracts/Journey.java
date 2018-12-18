package com.telerikacademy.agency.models.contracts;

import com.telerikacademy.agency.models.enums.VehicleType;

public interface Journey {
    String getDestination();

    int getDistance();

    String getStartLocation();

    VehicleType getVehicle();

    double calculateTravelCosts();
}
