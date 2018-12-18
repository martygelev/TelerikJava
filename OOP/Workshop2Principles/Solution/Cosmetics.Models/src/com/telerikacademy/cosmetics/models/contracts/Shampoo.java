package com.telerikacademy.cosmetics.models.contracts;

import com.telerikacademy.cosmetics.models.common.UsageType;

public interface Shampoo extends Product {
    public int getMilliliters();
    public UsageType getUsage();
}
