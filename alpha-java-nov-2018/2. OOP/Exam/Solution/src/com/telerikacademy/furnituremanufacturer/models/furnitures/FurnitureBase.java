package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.Furniture;
import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public abstract class FurnitureBase implements Furniture {
    private static final int MODEL_MIN_LENGTH = 3;
    private String model;
    private MaterialType materialType;
    private double price;
    private double height;

    public FurnitureBase(String model, MaterialType materialType, double price, double height)
    {
        setModel(model);
        setMaterialType(materialType);
        setPrice(price);
        setHeight(height);
    }

    void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height should not be less than zero");
        }
        this.height = height;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should not be less than zero");
        }
        this.price = price;
    }

    private void setMaterialType(MaterialType materialType) {
        if (materialType == null) {
            throw new IllegalArgumentException("Material Type should not be null");
        }
        this.materialType = materialType;
    }

    private void setModel(String model) {
        if (model == null) {
            throw new IllegalArgumentException("Model should not be null");
        }
        if (model.length() < MODEL_MIN_LENGTH) {
            throw new IllegalArgumentException("model should be at least 3 characters");
        }
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public MaterialType getMaterialType(){
        return materialType;
    }

    public double getPrice(){
        return price;
    }

    public double getHeight() {
        return this.height;
    }


    protected abstract String additionalInfo();

    @Override
    public String toString()
    {
        return String.format("Type: %s, Model: %s, Material: %s, Price: %.2f, Height: %.2f%s",
                this.getClass().getSimpleName().replace("Impl", ""), model, materialType, price, height, additionalInfo() );
    }
}
