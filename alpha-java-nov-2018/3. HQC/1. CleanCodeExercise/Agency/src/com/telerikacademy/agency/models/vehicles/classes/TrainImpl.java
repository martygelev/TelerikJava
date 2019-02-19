package com.telerikacademy.agency.models.vehicles.classes;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleBase implements Train {
    private static final int MIN_PAS_CAPACITY = 30;
    private static final int MAX_PAS_CAPACITY = 150;

    private int carts;

    public TrainImpl(int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }

    @Override
    public int getCarts() {
        return carts;
    }

    public void setCarts(int carts) {
        if (carts < MIN_NUM_CARTS || carts > MAX_NUM_CARTS) {
            throw new IllegalArgumentException("A train cannot have less than 1 cart or more than 15 carts.");
        }
        this.carts = carts;
    }

    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < getMinPassengers() || passengerCapacity > getMaxPassengers()) {
            throw new IllegalArgumentException("A train cannot have less than 30 passengers or more than 150 passengers.");
        }
        super.setPassengerCapacity(passengerCapacity);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.LAND;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder().append("Train ----").append(System.lineSeparator());
        sb.append(String.format("Passenger capacity: %d", getPassengerCapacity())).append(System.lineSeparator());
        sb.append(String.format("Price per kilometer: %.2f", getPricePerKilometer())).append(System.lineSeparator());
        sb.append(String.format("Vehicle type: %s", getVehicleType())).append(System.lineSeparator());

        sb.append(String.format("Carts amount: %d", getCarts()));

        return sb.toString();
    }

    @Override
    protected int getMaxPassengers() {
        return MAX_PAS_CAPACITY;
    }

    @Override
    protected int getMinPassengers() {
        return MIN_PAS_CAPACITY;
    }
}



