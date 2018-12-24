package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.Chair;
import com.telerikacademy.furnituremanufacturer.models.Enums.ChairType;
import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;

public class ChairImpl extends FurnitureImpl implements Chair {
    private static final String INVALID_CHAIR_TYPE_NAME ="Invalid chair name: %s";

    private int numberOfLegs;
    private ChairType chairType;

    public ChairImpl(String model, MaterialType materialType, double price, double height,int numberOfLegs,String chairType) {
        super(model, materialType, price, height);
        setNumberOfLegs(numberOfLegs);
        setChairType(getChairType(chairType));
    }

    public ChairType getChairType(String chair){
        switch (chair)
        {
            case "Normal":
                return ChairType.NORMAL;
            case "Adjustable":
                return ChairType.ADJUSTABLE;
            case "Convertible":
                return ChairType.CONVERTIBLE;
            default:
                throw new IllegalArgumentException(String.format(INVALID_CHAIR_TYPE_NAME, chair));
        }
    }

    private void setChairType(ChairType chairType) {
        this.chairType = chairType;
    }

    private void setNumberOfLegs(int numberOfLegs) {
        if (numberOfLegs<=0)
        {
            throw new IllegalArgumentException("Number of legs must be positive number");
        }
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public ChairType getChairType() {
        return chairType;
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    protected String additionalInfo() {
        return String.format("Legs: %d",this.getNumberOfLegs());
    }
}
