package com.telerikacademy.agency.models.vehicles.classes;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleBase implements Bus {
    private static final int MIN_PASSENGER_CAPACITY = 10;
    private static final int MAX_PASSENGER_CAPACITY = 50;
    public static final String BUS_INVALID_PASSENGERS_ERROR_MESSAGE = "A bus cannot have less than %d passengers or more than %d passengers.";

    public BusImpl(int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity, pricePerKilometer);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.LAND;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("Bus ----").append(System.lineSeparator());
        sb.append(super.toString());

        return sb.toString();
    }

    @Override
    protected int getMinPassengers() {
        return MIN_PASSENGER_CAPACITY;
    }

    @Override
    protected int getMaxPassengers() {
        return MAX_PASSENGER_CAPACITY;
    }

    @Override
    protected String getVehicleInvalidPassengerErrorMessage() {
        return BUS_INVALID_PASSENGERS_ERROR_MESSAGE;
    }
}
