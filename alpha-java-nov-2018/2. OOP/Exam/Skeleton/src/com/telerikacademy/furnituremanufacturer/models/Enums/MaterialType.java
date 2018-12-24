package com.telerikacademy.furnituremanufacturer.models.Enums;

public enum MaterialType {
    WOODEN,
    LEATHER,
    PLASTIC;

    @Override
    public String toString() {
        switch (this) {
            case WOODEN:
                return "Wooden";
            case LEATHER:
                return "Leather";
            case PLASTIC:
                return "Plastic";

            default:
                throw new IllegalArgumentException("Invalid material type");
        }
    }
}
