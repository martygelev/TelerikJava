package com.telerikacademy.agency.models.vehiclesImpl;
import com.telerikacademy.agency.models.enums.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {
    private final static int MAX_PASSENGER_CAPACITY=50;
    private final static int MIN_PASSENGER_CAPACITY =10;
    private final static String PASSENGER_CAPACITY_MESSAGE = "A bus cannot have less than 10 passengers or more than 50 passengers.";
    private final static String CURRENT_VEHICLE_NAME = "Bus ----";
    private VehicleType type = VehicleType.Land;

    @Override
    public VehicleType getType() {
        return type;
    }

    public BusImpl(int passengerCapacity, double pricePerKm) {
        super(passengerCapacity, pricePerKm);
    }

    @Override
    public  int getMinPassengerCapacity() {
        return MIN_PASSENGER_CAPACITY;
    }

    @Override
    public  int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }

    @Override
    public  String getPassengerCapacityMessage() {
        return PASSENGER_CAPACITY_MESSAGE;
    }

    @Override
    public  String getCurrentVehicleName() {
        return CURRENT_VEHICLE_NAME;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.1f\n" +
                "Vehicle type: %s",getCurrentVehicleName(),getPassengerCapacity(),getPricePerKilometer(),getType());
    }
}
