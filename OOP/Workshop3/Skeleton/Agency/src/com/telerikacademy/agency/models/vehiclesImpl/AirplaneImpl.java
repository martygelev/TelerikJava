package com.telerikacademy.agency.models.vehiclesImpl;

import com.telerikacademy.agency.models.enums.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {
    private boolean hasFreeFood;
    private VehicleType vehicleType = VehicleType.Air;
    private final static String CURRENT_VEHICLE_NAME = "Airplane ----";

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public String getCurrentVehicleName() {
        return CURRENT_VEHICLE_NAME;
    }

    public AirplaneImpl(int passengerCapacity, double pricePerKm, boolean food) {
        super(passengerCapacity, pricePerKm);
        setHasFreeFood(food);
    }

    private void setHasFreeFood(boolean hasFreeFood) {
        if (hasFreeFood)
            this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood(boolean food) {
        return hasFreeFood;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Has free food: ").append(hasFreeFood ? "true" : "false");

        return String.format("%s\n" +
                "Has free food: %s", super.toString(), (hasFreeFood ? "true" : "false"));
    }
}
