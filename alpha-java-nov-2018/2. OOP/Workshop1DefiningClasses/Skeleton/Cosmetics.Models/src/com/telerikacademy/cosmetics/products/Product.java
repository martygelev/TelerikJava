package com.telerikacademy.cosmetics.products;

import com.telerikacademy.cosmetics.common.GenderType;

public class Product {
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        setPrice(price);
    }

    public Product(Product product) {
        price = product.price;


    }

    public String print() {
        return "";
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
    }
}
