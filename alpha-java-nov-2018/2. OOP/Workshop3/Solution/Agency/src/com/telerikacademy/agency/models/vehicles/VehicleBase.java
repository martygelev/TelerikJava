package com.telerikacademy.agency.models.vehicles;

import com.telerikacademy.agency.models.common.ValidatorHelper;
import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleBase implements Vehicle {
    private static final String PASSENGER_CAPACITY_ERROR = "A vehicle with less than %d passengers or more than %d passengers cannot exist!";
    private static final int PASSENGER_CAPACITY_MIN_VALUE = 1;
    private static final int PASSENGER_CAPACITY_MAX_VALUE = 800;

    private static final String PRICE_PER_KM_ERROR = "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    private static final double PRICE_PER_KM_MIN_VALUE = 0.1;
    private static final double PRICE_PER_KM_MAX_VALUE = 2.5;

    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType type;

    VehicleBase(int passengerCapacity, double pricePerKilometer, VehicleType type) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.type = type;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < getPassengerCapacityMinValue() || passengerCapacity > getPassengerCapacityMaxValue()) {
            throw new IllegalArgumentException(getPassengerCapacityIllegalArgumentMessage());
        }

        this.passengerCapacity = passengerCapacity;
    }

//    // use validator helper - you can use it across other setters if you like so. Just keep it consistent
//    private void setPassengerCapacity(int passengerCapacity) {
//        ValidatorHelper.validateInterval(getPassengerCapacityMinValue(),
//                getPassengerCapacityMaxValue(),
//                passengerCapacity,
//                getPassengerCapacityIllegalArgumentMessage());
//
//        this.passengerCapacity = passengerCapacity;
//    }

    private void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < getPricePerKilometerMinValue() || pricePerKilometer > getPricePerKilometerMaxValue()) {
            throw new IllegalArgumentException(getPricePerKilometerIllegalArgumentMessage());
        }

        this.pricePerKilometer = pricePerKilometer;
    }

    protected int getPassengerCapacityMinValue() {
        return PASSENGER_CAPACITY_MIN_VALUE;
    }

    protected int getPassengerCapacityMaxValue() {
        return PASSENGER_CAPACITY_MAX_VALUE;
    }

    protected String getPassengerCapacityIllegalArgumentMessage() {
        return String.format(PASSENGER_CAPACITY_ERROR, getPassengerCapacityMinValue(), getPassengerCapacityMaxValue());
    }

    protected double getPricePerKilometerMinValue() {
        return PRICE_PER_KM_MIN_VALUE;
    }

    protected double getPricePerKilometerMaxValue() {
        return PRICE_PER_KM_MAX_VALUE;
    }

    protected String getPricePerKilometerIllegalArgumentMessage() {
        return String.format(PRICE_PER_KM_ERROR, getPricePerKilometerMinValue(), getPricePerKilometerMaxValue());
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(printClassName());
        sb.append(System.lineSeparator());
        sb.append(printDetails());
        return sb.toString();
    }

    // some classes may have more details, some may not - implement base functionality & provide a way to be inherited
    protected String printDetails() {
        return String.format(
                "Passenger capacity: %d" + System.lineSeparator() +
                        "Price per kilometer: %.2f" + System.lineSeparator() +
                        "Vehicle type: %s" + System.lineSeparator(), getPassengerCapacity(), getPricePerKilometer(), getType());

    }

    // We need to make sure all derived classes implement this method - make it abstract
    public abstract String printClassName();

    public String toString() {
        return print();
    }
}
