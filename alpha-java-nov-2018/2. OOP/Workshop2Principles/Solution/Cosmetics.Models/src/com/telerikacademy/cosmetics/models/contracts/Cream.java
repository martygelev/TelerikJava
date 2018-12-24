package com.telerikacademy.cosmetics.models.contracts;

import com.telerikacademy.cosmetics.models.common.ScentType;

public interface Cream extends Product {
    public ScentType getScent();
}
