package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.ConvertibleChair;
import com.telerikacademy.furnituremanufacturer.models.Enums.ChairType;
import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;

public class ConvertibleChairImpl extends ChairImpl implements ConvertibleChair {
    private ChairType chairType=ChairType.NORMAL;

    public ConvertibleChairImpl(String model, MaterialType materialType, double price,
                                double height, int numberOfLegs, String chairType) {
        super(model, materialType, price, height, numberOfLegs, chairType);
    }

    @Override
    public boolean getIsConverted() {
        return this.getChairType().equals(ChairType.CONVERTIBLE);
    }

    @Override
    public String additionalInfo(){
        return String.format("%s, State: %s",super.additionalInfo(),getIsConverted() ? "Converted" : "Normal");
    }

    @Override
    public ChairType getChairType() {
        return chairType;
    }

    private void setChair(ChairType chair) {
        this.chairType = chair;
    }

    @Override
    public void convert() {
        setChair(ChairType.CONVERTIBLE);

    }
}

