package com.telerikacademy.cosmetics.models.products;

import com.telerikacademy.cosmetics.models.common.GenderType;

import java.util.Comparator;

public class Product implements Cloneable, Comparable {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;

    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String toString() {
        return print();
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public GenderType getGender() {
        return gender;
    }

    protected void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    protected void setBrand(String brand) {
        if (brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
    }

    protected void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String print() {
        return String.format("#%s %s\n" +
                " #Price: %f\n" +
                " #Gender: %s\n" +
                " ===", name, brand, price, gender);

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Product)) {
            throw new IllegalArgumentException();
        }
        Product other = (Product) o;
        int brandComp = brand.compareTo(other.brand);
        if (brandComp != 0) {
            return brandComp;
        }
        return Double.compare(price, other.price) * -1;
    }
}
