package com.telerikacademy.cosmetics.models.products;

import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.contracts.Product;

public class ProductBase implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;
    private static final int PRICE_MIN_VALUE = 0;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < getNameMinLength() || name.length() > getNameMaxLength()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null) {
            throw new IllegalArgumentException();
        }
        if (brand.length() < getBrandMinLength() || brand.length() > getBrandMaxLength()) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!isPriceValid()) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    protected boolean isPriceValid() {
        return price <= getPriceMinValue();
    }

    @Override
    public GenderType getGender() {
        return gender;
    }

    public String print() {
        return String.format("#%s %s\n" +
                " #Price: $%f\n" +
                " #Gender: %s\n", getName(), getBrand(), getPrice(), getGender());
    }

    protected int getNameMinLength() {
        return NAME_MIN_LENGTH;
    }

    protected int getNameMaxLength() {
        return NAME_MAX_LENGTH;
    }

    protected int getBrandMinLength() {
        return BRAND_MIN_LENGTH;
    }

    protected int getBrandMaxLength() {
        return BRAND_MAX_LENGTH;
    }

    protected int getPriceMinValue() {
        return PRICE_MIN_VALUE;
    }
}
