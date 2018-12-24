package com.telerikacademy.agency.models.vehicles;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleBase implements Bus {
    private final static String CLASS_NAME_PRINT= "Bus ----";
    private static final String PASSENGER_CAPACITY_ERROR = "A bus cannot have less than %d passengers or more than %d passengers.";
    private static final int PASSENGER_CAPACITY_MIN_VALUE = 10;
    private static final int PASSENGER_CAPACITY_MAX_VALUE = 50;

    public BusImpl(int passengerCapacity, double pricePerKilometer) {
        super(passengerCapacity, pricePerKilometer, VehicleType.LAND);
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

    public String printClassName() {
        return CLASS_NAME_PRINT;
    }
}
