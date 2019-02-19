package com.telerikacademy.furnituremanufacturer.interfaces.engine;

import com.telerikacademy.furnituremanufacturer.interfaces.*;

public interface FurnitureFactory {

    Table createTable(String model, String materialType, double price, double height, double length, double width);

    Chair createChair(String model, String materialType, double price, double height, int numberOfLegs);

    AdjustableChair createAdjustableChair(String model, String materialType, double price, double height, int numberOfLegs);

    ConvertibleChair createConvertibleChair(String model, String materialType, double price, double height, int numberOfLegs);
}
