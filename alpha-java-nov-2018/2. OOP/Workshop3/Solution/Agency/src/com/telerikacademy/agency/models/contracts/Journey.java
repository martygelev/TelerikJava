package com.telerikacademy.agency.models.contracts;

import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public interface Journey extends Printable{
    String getDestination();

    int getDistance();

    String getStartLocation();

    Vehicle getVehicle();

    double calculateTravelCosts();
}