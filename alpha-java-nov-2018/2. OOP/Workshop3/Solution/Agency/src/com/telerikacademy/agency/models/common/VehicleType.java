package com.telerikacademy.agency.models.common;

public enum VehicleType {
    LAND,
    AIR,
    SEA;

    @Override
    public String toString() {
        return this.name().substring(0,1) + this.name().substring(1).toLowerCase();
    }
}
