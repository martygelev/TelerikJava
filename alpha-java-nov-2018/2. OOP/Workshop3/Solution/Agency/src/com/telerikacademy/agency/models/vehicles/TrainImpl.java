package com.telerikacademy.agency.models.vehicles;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleBase implements Train {
    private final static String CLASS_NAME_PRINT= "Train ----";
    private static final String PASSENGER_CAPACITY_ERROR = "A train cannot have less than %d passengers or more than %d passengers.";
    private static final int PASSENGER_CAPACITY_MIN_VALUE = 30;
    private static final int PASSENGER_CAPACITY_MAX_VALUE = 150;
    private static final String CARTS_CAPACITY_ERROR = "A train cannot have less than %d cart or more than %d carts.";
    private static final int CARTS_CAPACITY_MIN_VALUE = 1;
    private static final int CARTS_CAPACITY_MAX_VALUE = 15;

    private int carts;

    public TrainImpl(int passengerCapacity, double pricePerKilometer, int carts) {
        super(passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
    }

    private void setCarts(int carts){
        if (carts < CARTS_CAPACITY_MIN_VALUE || carts > CARTS_CAPACITY_MAX_VALUE){
            throw new IllegalArgumentException(String.format(CARTS_CAPACITY_ERROR, CARTS_CAPACITY_MIN_VALUE, CARTS_CAPACITY_MAX_VALUE));
        }

        this.carts = carts;
    }

    protected String getPassengerCapacityIllegalArgumentMessage() {
        return String.format(PASSENGER_CAPACITY_ERROR, getPassengerCapacityMinValue(), getPassengerCapacityMaxValue());
    }

    protected int getPassengerCapacityMaxValue() {
        return PASSENGER_CAPACITY_MAX_VALUE;
    }

    protected int getPassengerCapacityMinValue() {
        return PASSENGER_CAPACITY_MIN_VALUE;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder(super.printDetails());
        sb.append(String.format("Carts amount: %d" + System.lineSeparator(), getCarts()));
        return sb.toString();
    }

    @Override
    public String printClassName() {
           return CLASS_NAME_PRINT;
    }
}
