package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.AdjustableChair;
import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;

public class AdjustableChairImpl extends ChairImpl implements AdjustableChair {
    private double height; // possible error
    // TODO: 20.12.18

    public AdjustableChairImpl(String model, MaterialType materialType, double price, double height, int numberOfLegs, String chairType) {
        super(model, materialType, price, height, numberOfLegs, chairType);
    }

    @Override
    public void setHeight(double heightChange) {
        if (heightChange <= 0) {
            throw new IllegalArgumentException("Height should not be less than zero");
        }

        this.height=heightChange;

    }
}
