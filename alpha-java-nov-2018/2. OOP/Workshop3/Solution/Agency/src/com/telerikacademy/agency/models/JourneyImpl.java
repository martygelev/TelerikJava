package com.telerikacademy.agency.models;

import com.telerikacademy.agency.models.contracts.Journey;
import com.telerikacademy.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {
    private static final String PLACE_ERROR = "The %s's length cannot be less than %d or more than %d symbols long.";
    private static final int PLACE_LENGTH_MIN_VALUE = 5;
    private static final int PLACE_LENGTH_MAX_VALUE = 25;
    private static final String START_LOCATION_NAME = "StartingLocation";
    private static final String DESTINATION_NAME = "Destination";
    private static final String DISTANCE_ERROR = "The Distance cannot be less than %d or more than %d kilometers.";
    private static final int DISTANCE_MIN_VALUE = 5;
    private static final int DISTANCE_MAX_VALUE = 5000;

    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;

    public JourneyImpl(String startLocation, String destination, int distance, Vehicle vehicle) {
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;
    }

    private void validatePlace(String place, String placeName) {
        if (place == null) {
            throw new IllegalArgumentException();
        }

        if (place.length() < PLACE_LENGTH_MIN_VALUE || place.length() > PLACE_LENGTH_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(PLACE_ERROR, placeName, PLACE_LENGTH_MIN_VALUE, PLACE_LENGTH_MAX_VALUE));
        }
    }

    private void setStartLocation(String startLocation) {
        validatePlace(startLocation, START_LOCATION_NAME);
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        validatePlace(destination, DESTINATION_NAME);
        this.destination = destination;
    }

    private void setDistance(int distance) {
        if (distance < DISTANCE_MIN_VALUE || distance > DISTANCE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(DISTANCE_ERROR, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE));
        }

        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public double calculateTravelCosts() {
        return vehicle.getPricePerKilometer() * getDistance();
    }

    @Override
    public String print() {
        return String.format("Journey ----" + System.lineSeparator() +
                "Start location: %s" + System.lineSeparator() +
                "Destination: %s" + System.lineSeparator() +
                "Distance: %d" + System.lineSeparator() +
                "Vehicle type: %s" + System.lineSeparator() +
                "Travel costs: %.2f" + System.lineSeparator(), getStartLocation(), getDestination(), getDistance(), getVehicle().getType(), calculateTravelCosts());
    }

    @Override
    public String toString() {
        return print();
    }
}
