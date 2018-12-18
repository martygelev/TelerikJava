package com.telerikacademy.cosmetics.models.products;

import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.UsageType;
import com.telerikacademy.cosmetics.models.contracts.Shampoo;

public class ShampooImpl extends ProductBase implements Shampoo {
    private int milliliters;
    private UsageType usage;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.usage = usage;
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException();
        }
        this.milliliters = milliliters;
    }

    @Override
    public UsageType getUsage() {
        return usage;
    }

    @Override
    public String print() {
        return String.format("%s\n" +
                " #Milliliters: %d\n" +
                " #Usage: %s\n" +
                " ===", super.print(), milliliters, usage);
    }
}
