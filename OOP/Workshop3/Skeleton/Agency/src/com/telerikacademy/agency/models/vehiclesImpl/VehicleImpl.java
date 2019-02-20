package com.telerikacademy.agency.models.vehiclesImpl;

import com.telerikacademy.agency.models.enums.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public class VehicleImpl implements Vehicle {
    private final static double MIN_PRICE_PER_KM = 0.10;
    private final static double MAX_PRICE_PER_KM = 2.50;
    private final static int MAX_PASSENGER_CAPACITY = 800;
    private final static int MIN_PASSENGER_CAPACITY = 1;
    private final static String PASSENGER_CAPACITY_MESSAGE = "A vehicle with less than 1 passengers or more than 800 passengers cannot exist!";
    private final static String PRICE_PER_KM_MESSAGE = "A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!";
    private final static String CURRENT_VEHICLE_NAME = "Vehicle ----";

    private int passengerCapacity;
    private double pricePerKm;
    private VehicleType type = VehicleType.Land;

    public VehicleImpl(int passengerCapacity, double pricePerKm) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKm(pricePerKm);
    }

    private void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < getMinPassengerCapacity() || passengerCapacity > getMaxPassengerCapacity()) {
            throw new IllegalArgumentException(getPassengerCapacityMessage());
        }
        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKm(double pricePerKm) {
        if (pricePerKm < MIN_PRICE_PER_KM || pricePerKm > MAX_PRICE_PER_KM) {
            throw new IllegalArgumentException(PRICE_PER_KM_MESSAGE);
        }
        this.pricePerKm = pricePerKm;
    }

    protected int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }

    protected int getMinPassengerCapacity() {
        return MIN_PASSENGER_CAPACITY;
    }

    protected String getPassengerCapacityMessage() {
        return PASSENGER_CAPACITY_MESSAGE;
    }

    protected String getCurrentVehicleName() {
        return CURRENT_VEHICLE_NAME;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s", getCurrentVehicleName(), getPassengerCapacity(), getPricePerKilometer(), getType());
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKm;
    }

    @Override
    public VehicleType getType() {
        return type;
    }
}
