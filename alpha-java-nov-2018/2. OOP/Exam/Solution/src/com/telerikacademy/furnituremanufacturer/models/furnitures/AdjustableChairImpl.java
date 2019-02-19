package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.AdjustableChair;
import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public class AdjustableChairImpl extends ChairImpl implements AdjustableChair {


    public AdjustableChairImpl(String model, MaterialType materialType, double price, double height, int numberOfLegs) {
        super(model, materialType, price, height, numberOfLegs);

    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }
}
