package com.telerikacademy.agency.models.vehicles.classes;

import com.telerikacademy.agency.models.common.VehicleType;
import com.telerikacademy.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleBase implements Airplane {

    private boolean hasFreeFood;

    public AirplaneImpl(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(passengerCapacity, pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.AIR;
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append("Airplane ----").append(System.lineSeparator());
        sb.append(super.print()).append(System.lineSeparator());
        sb.append(String.format("Has free food: %s", String.valueOf(hasFreeFood())));

        return sb.toString();
    }

    protected void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }
}
