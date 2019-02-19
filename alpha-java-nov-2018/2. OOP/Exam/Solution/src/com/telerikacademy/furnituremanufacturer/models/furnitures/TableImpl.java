package com.telerikacademy.furnituremanufacturer.models.furnitures;

import com.telerikacademy.furnituremanufacturer.interfaces.Table;
import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public class TableImpl extends FurnitureBase implements Table {

    private  double length;
    private  double width;

    public TableImpl(String model, MaterialType materialType, double price, double height, double length, double width)
    {
        super(model, materialType, price, height );

        setLength(length);
        setWidth(width);
    }

    private void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be less than zero");
        }
        this.width = width;
    }

    private void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be less than zero");
        }
        this.length = length;
    }

    public double getLength(){
        return length;
    }

    public double getWidth (){
        return width;
    }

    public double getArea() {
        return length * width;
    }

    protected String additionalInfo() {

        return String.format(", Length: %.2f, Width: %.2f, Area: %.4f", length, width, getArea());
    }
}
