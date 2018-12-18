package com.telerikacademy.agency.models.vehiclesImpl;
import com.telerikacademy.agency.models.enums.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {
    private final static int MAX_PASSENGER_CAPACITY=150;
    private final static int MIN_PASSENGER_CAPACITY =30;
    private final static String PASSENGER_CAPACITY_MESSAGE = "A train cannot have less than 30 passengers or more than 150 passengers.";
    private final static String CURRENT_VEHICLE_NAME = "Train ----";
    private final static String CARTS_MESSAGE = "A train cannot have less than 1 cart or more than 15 carts.";
    private final static int MIN_CARTS = 1;
    private final static int MAX_CARTS =15;
    private int carts;
    private VehicleType type = VehicleType.Land;

    @Override
    public VehicleType getType() {
        return type;
    }
    public TrainImpl(int passengerCapacity, double pricePerKm, int carts) {
        super(passengerCapacity, pricePerKm);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        if (carts<=MIN_CARTS || carts>=MAX_CARTS)
        {
            throw new IllegalArgumentException(CARTS_MESSAGE);
        }
        this.carts=carts;
    }

    @Override
    public final int getCarts() {
        return carts;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Carts amount: %d",super.toString(),getCarts());
    }

    @Override
    protected int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }

    @Override
    protected int getMinPassengerCapacity() {
        return MIN_PASSENGER_CAPACITY;
    }

    @Override
    protected String getCurrentVehicleName() {
        return CURRENT_VEHICLE_NAME;
    }

    @Override
    protected String getPassengerCapacityMessage() {
        return PASSENGER_CAPACITY_MESSAGE;
    }
}
