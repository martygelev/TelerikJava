package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.Chair;
import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public class ChairImpl extends FurnitureBase implements Chair {

    private int numberOfLegs;

    public ChairImpl(String model, MaterialType materialType, double price, double height, int numberOfLegs)
    {
        super(model, materialType, price, height);
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
       return numberOfLegs;
    }

    protected String additionalInfo()
    {
        return String.format(", Legs: %d", numberOfLegs);
    }

}
