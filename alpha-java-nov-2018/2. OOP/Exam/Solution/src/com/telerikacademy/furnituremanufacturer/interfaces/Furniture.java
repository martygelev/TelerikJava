package com.telerikacademy.furnituremanufacturer.interfaces;

import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public interface Furniture {

    String getModel();

    MaterialType getMaterialType();

    double getPrice();

    double getHeight();
}
