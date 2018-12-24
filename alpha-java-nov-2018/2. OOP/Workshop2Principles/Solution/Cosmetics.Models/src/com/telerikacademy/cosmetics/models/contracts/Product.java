package com.telerikacademy.cosmetics.models.contracts;

import com.telerikacademy.cosmetics.models.common.GenderType;

public interface Product {
    String getName();
    String getBrand();
    double getPrice();
    GenderType getGender();
    String print();
}
