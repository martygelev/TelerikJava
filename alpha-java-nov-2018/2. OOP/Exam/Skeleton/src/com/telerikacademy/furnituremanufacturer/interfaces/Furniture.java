package com.telerikacademy.furnituremanufacturer.interfaces;

import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;

public interface Furniture {

    String getModel();

    MaterialType getMaterialType();

    double getPrice();

    double getHeight();

}
