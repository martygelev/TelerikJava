package com.telerikacademy.furnituremanufacturer.engine.factories;

import com.telerikacademy.furnituremanufacturer.interfaces.*;
import com.telerikacademy.furnituremanufacturer.interfaces.engine.FurnitureFactory;
import com.telerikacademy.furnituremanufacturer.models.Enums.ChairType;
import com.telerikacademy.furnituremanufacturer.models.Enums.MaterialType;
import com.telerikacademy.furnituremanufacturer.models.furnitures.AdjustableChairImpl;
import com.telerikacademy.furnituremanufacturer.models.furnitures.ChairImpl;
import com.telerikacademy.furnituremanufacturer.models.furnitures.ConvertibleChairImpl;
import com.telerikacademy.furnituremanufacturer.models.furnitures.TableImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FurnitureFactoryImpl implements FurnitureFactory {
    private static final String WOODEN = "wooden";
    private static final String LEATHER = "leather";
    private static final String PLASTIC = "plastic";
    private static final String INVALID_MATERIAL_NAME = "Invalid material name: %s";

    @Override
    public Table createTable(String model, String materialType, double price, double height, double length, double width) {
        return new TableImpl(model,getMaterialType(materialType),price,height,length,width);
    }

    @Override
    public Chair createChair(String model, String materialType, double price, double height, int numberOfLegs,String chair) {
          return new ChairImpl(model,getMaterialType(materialType),price,height,numberOfLegs,chair);
    }

    @Override
    public AdjustableChair createAdjustableChair(String model, String materialType, double price,
                                                 double height, int numberOfLegs,String chairType) {
       return new AdjustableChairImpl(model,getMaterialType(materialType),price,height,numberOfLegs,chairType);
    }

    @Override
    public ConvertibleChair createConvertibleChair(String model, String materialType, double price,
                                                   double height, int numberOfLegs,String chairType) {
         return new ConvertibleChairImpl(model,getMaterialType(materialType),price,height,numberOfLegs,chairType);
    }

    private MaterialType getMaterialType(String material){
        switch (material) {
            case WOODEN:
                return MaterialType.WOODEN;
            case LEATHER:
                return MaterialType.LEATHER;
            case PLASTIC:
                return MaterialType.PLASTIC;
            default:
                throw new IllegalArgumentException(String.format(INVALID_MATERIAL_NAME, material));
        }
    }
}
