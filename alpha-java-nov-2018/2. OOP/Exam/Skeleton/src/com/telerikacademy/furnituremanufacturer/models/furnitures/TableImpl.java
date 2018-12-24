package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.Table;
import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;

public class TableImpl extends FurnitureImpl implements Table {
    private double length;
    private double width;

    public TableImpl(String model, MaterialType materialType, double price, double height,double length, double width ) {
        super(model, materialType, price, height);
        setLength(length);
        setWidth(width);
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    protected String additionalInfo() {
        return String.format("Length: %.2f, Width: %.2f, Area: %.4f",this.getLength(),this.getWidth(),this.getArea());
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return getLength()*getWidth();
    }
}
