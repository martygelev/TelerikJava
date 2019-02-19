package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.ConvertibleChair;
import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public class ConvertibleChairImpl extends ChairImpl implements ConvertibleChair {

    private static final String CONVERTED = "Converted";
    private static final String NORMAL_POSITION = "Normal";
    private double originalHeight;
    private double currentHeight;
    private boolean isConverted;

    public ConvertibleChairImpl(String model, MaterialType materialType, double price, double height, int numberOfLegs)
    {
        super(model, materialType, price, height, numberOfLegs);
        originalHeight = height;
        currentHeight = height;
        isConverted = false;
    }

    public boolean getIsConverted() {
        return isConverted;
    }

    public void convert() {

        isConverted = !isConverted;
        currentHeight = isConverted ? 0.1 : originalHeight;
    }

    protected String additionalInfo()
    {
        return String.format("%s, State: %s",
                super.additionalInfo(), isConverted ? CONVERTED : NORMAL_POSITION);
    }
}
