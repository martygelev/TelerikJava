package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.enums.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {
    private final static int MIN_LENGTH = 5;
    private final static int MAX_LENGTH = 25;
    private final static int DISTANCE_MIN = 5;
    private final static int DISTANCE_MAX = 5000;
    private final static String STARTING_LOCATION_EXCEPTION_MESSAGE = "The StartingLocation's length cannot be less than 5 or more than 25 symbols long.";
    private final static String DESTINATION_EXCEPTION_MESSAGE = "The Destination's length cannot be less than 5 or more than 25 symbols long.";
    private final static String DISTANCE_MESSAGE = "The Distance cannot be less than 5 or more than 5000 kilometers.";

    private String startingLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;

    public JourneyImpl(String startingLocation, String destination, int distance, Vehicle vehicle) {
        setStartingLocation(startingLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private void setStartingLocation(String startingLocation) {
        if (startingLocation == null || startingLocation.length() < MIN_LENGTH
                || startingLocation.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(STARTING_LOCATION_EXCEPTION_MESSAGE);
        }
        this.startingLocation = startingLocation;
    }

    private void setDestination(String destination) {
        if (destination == null || destination.length() < MIN_LENGTH || destination.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(DESTINATION_EXCEPTION_MESSAGE);
        }
        this.destination = destination;
    }

    private void setDistance(int distance) {
        if (distance < DISTANCE_MIN || distance > DISTANCE_MAX) {
            throw new IllegalArgumentException(DISTANCE_MESSAGE);
        }
        this.distance = distance;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String getStartLocation() {
        return startingLocation;
    }

    @Override
    public VehicleType getVehicle() {
        return vehicle.getType();
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    @Override
    public String toString() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f", getStartLocation(), getDestination(), getDistance(), getVehicle(), calculateTravelCosts());
    }
}
