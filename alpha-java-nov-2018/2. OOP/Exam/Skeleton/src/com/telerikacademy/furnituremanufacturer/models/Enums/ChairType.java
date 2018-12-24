package com.telerikacademy.furnituremanufacturer.models.Enums;

public enum ChairType {
    NORMAL,
    ADJUSTABLE,
    CONVERTIBLE;

    @Override
    public String toString() {
        switch (this) {
            case NORMAL:
                return "Normal";
            case ADJUSTABLE:
                return "Adjustable";
            case CONVERTIBLE:
                return "Convertable";

            default:
                throw new IllegalArgumentException("Invalid chair type");
        }
    }
}
