package com.telerikacademy.cosmetics.models.products;

import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.ScentType;
import com.telerikacademy.cosmetics.models.contracts.Cream;

public class CreamImpl extends ProductBase implements Cream {
    private static final int NAME_MAX_LENGTH = 15;
    private static final int BRAND_MIN_LENGTH = 3;
    private static final int BRAND_MAX_LENGTH = 15;

    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent = scent;
    }

    @Override
    public ScentType getScent() {
        return scent;
    }

    @Override
    protected int getNameMaxLength() {
        return NAME_MAX_LENGTH;
    }

    @Override
    protected int getBrandMinLength() {
        return BRAND_MIN_LENGTH;
    }

    @Override
    protected int getBrandMaxLength() {
        return BRAND_MAX_LENGTH;
    }

    @Override
    protected boolean isPriceValid() {
        return getPrice() < getPriceMinValue();
    }

    @Override
    public String print() {
        return String.format("%s\n" +
                " #Scent: %s\n" +
                " ===", super.print(), scent);
    }
}
