package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {
    private static final int MAX_SYMBOLS_START_LOCATION = 25;
    private static final int MIN_SYMBOLS_START_LOCATION = 5;

    private static final int MAX_SYMBOLS_DESTINATION = 25;
    private static final int MIN_SYMBOLS_DESTINATION = 5;

    private static final int MAX_DISTANCE_RANGE = 5000;
    private static final int MIN_DISTANCE_RANGE = 5;

    private String startLocation;
    private String destination;
    private int Distance;
    private Vehicle vehicle;
    private double travelCost;

    public JourneyImpl(String startLocation, String destination, int distance, Vehicle vehicle) {
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
        setTravelCost(vehicle, distance);
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    protected void setStartLocation(String startLocation) {
        if (startLocation.length() < MIN_SYMBOLS_START_LOCATION || startLocation.length() > MAX_SYMBOLS_START_LOCATION) {
            throw new IllegalArgumentException("The StartingLocation's length cannot be less than 5 or more than 25 symbols long.");
        }
        this.startLocation = startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    protected void setDestination(String destination) {
        if (destination.length() < MIN_SYMBOLS_DESTINATION || destination.length() > MAX_SYMBOLS_DESTINATION) {
            throw new IllegalArgumentException("The Destination's length cannot be less than 5 or more than 25 symbols long.");
        }
        this.destination = destination;
    }

    @Override
    public int getDistance() {
        return Distance;
    }

    protected void setDistance(int distance) {
        if (distance < MIN_DISTANCE_RANGE || distance > MAX_DISTANCE_RANGE) {
            throw new IllegalArgumentException("The Distance cannot be less than 5 or more than 5000 kilometers.");
        }
        Distance = distance;
    }

    public double getTravelCost() {
        return travelCost;
    }

    protected void setTravelCost(Vehicle vehicle, int distance) {
        this.travelCost = vehicle.getPricePerKilometer() * distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    protected void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String print() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f", getStartLocation(), getDestination(), getDistance(), vehicle.getVehicleType(), getTravelCost());
    }
}
