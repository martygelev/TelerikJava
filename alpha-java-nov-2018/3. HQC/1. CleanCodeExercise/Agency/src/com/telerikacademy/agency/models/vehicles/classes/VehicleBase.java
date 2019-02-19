package com.telerikacademy.agency.models.vehicles.classes;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleBase implements Vehicle {
    private static final int MIN_PASSENGERS_CAPACITY = 1;
    private static final int MAX_PASSENGERS_CAPACITY = 800;
    private static final String VEHICLE_INVALID_PASSENGER_ERROR_MESSAGE = "A vehicle with less than %d passengers or more than %d passengers cannot exist!";

    private static final double MIN_PRICE_PER_KM = 0.10;
    private static final double MAX_PRICE_PER_KM = 2.50;
    private static final String VEHICLE_INVALID_PRICE_ERROR_MESSAGE = "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";


    private double pricePerKilometer;
    private int passengerCapacity;

    public VehicleBase(int passengerCapacity, double pricePerKilometer) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public abstract VehicleType getVehicleType();

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Passenger capacity: %d", getPassengerCapacity())).append(System.lineSeparator());
        sb.append(String.format("Price per kilometer: %.1f", getPricePerKilometer())).append(System.lineSeparator());
        sb.append(String.format("Vehicle type: %s", getVehicleType()));

        return sb.toString();
    }

    protected void setPassengerCapacity(int passengerCapacity) {
        ensureArgumentIsInRange(passengerCapacity, getMinPassengers(), getMaxPassengers(), getVehicleInvalidPassengerErrorMessage());
        this.passengerCapacity = passengerCapacity;
    }

    protected int getMaxPassengers() {
        return MAX_PASSENGERS_CAPACITY;
    }

    protected int getMinPassengers() {
        return MIN_PASSENGERS_CAPACITY;
    }

    protected String getVehicleInvalidPassengerErrorMessage() {
        return VEHICLE_INVALID_PASSENGER_ERROR_MESSAGE;
    }

    protected double getMinPricePerKM() {
        return MIN_PRICE_PER_KM;
    }

    protected double getMaxPricePerKM() {
        return MAX_PRICE_PER_KM;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        ensureArgumentIsInRange(pricePerKilometer, getMinPricePerKM(), getMaxPricePerKM(), VEHICLE_INVALID_PRICE_ERROR_MESSAGE);
        this.pricePerKilometer = pricePerKilometer;
    }

    private void ensureArgumentIsInRange(double fieldToValidate, double minValue, double maxValue, String invalidValueErrorMessage) {
        if (fieldToValidate < minValue || fieldToValidate > maxValue) {
            throw new IllegalArgumentException(String.format(invalidValueErrorMessage, minValue, maxValue));
        }
    }
}
