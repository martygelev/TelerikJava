package com.telerikacademy.agency.models.vehicles.contracts;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.contracts.Printable;

public interface Vehicle extends Printable {
    int getPassengerCapacity();

    double getPricePerKilometer();

    VehicleType getType();
}
