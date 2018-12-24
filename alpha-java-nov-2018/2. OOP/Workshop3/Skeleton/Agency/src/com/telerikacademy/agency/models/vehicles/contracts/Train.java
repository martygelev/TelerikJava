package com.telerikacademy.agency.models.vehicles.contracts;

public interface Train {
    int getPassengerCapacity();

    double getPricePerKilometer();

    // Please, please, please implement me
    VehicleType getType();

    void setType(VehicleType vehicleType);

    int getCarts();
}
