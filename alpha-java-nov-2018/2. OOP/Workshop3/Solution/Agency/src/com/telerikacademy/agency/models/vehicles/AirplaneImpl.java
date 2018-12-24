package com.telerikacademy.agency.models.vehicles;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleBase implements Airplane {
    private final static String CLASS_NAME_PRINT= "Airplane ----";
    private boolean hasFreeFood;

    public AirplaneImpl(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(passengerCapacity, pricePerKilometer, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String printDetails() {
        StringBuilder sb = new StringBuilder(super.printDetails());
        sb.append(String.format("Has free food: %b" + System.lineSeparator(), hasFreeFood()));
        return sb.toString();
    }

    @Override
    public String printClassName() {
        return CLASS_NAME_PRINT;
    }
}
