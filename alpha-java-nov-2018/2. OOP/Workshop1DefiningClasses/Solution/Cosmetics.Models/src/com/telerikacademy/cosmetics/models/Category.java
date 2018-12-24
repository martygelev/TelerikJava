package com.telerikacademy.cosmetics.models;

import com.telerikacademy.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Category {
    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 15;

    private String name;
    private List<Product> products;

    public Category(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        products.sort(Product::compareTo);
        return new ArrayList<>(products);

        // deep copy
//        ArrayList<Product> copyProducts = new ArrayList<>();
//
//        for (Product p : products) {
//            Product p1 = new Product(p.getName(), p.getBrand(), p.getPrice(), p.getGender());
//            copyProducts.add(p1);
//        }
//
//        return copyProducts;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (!products.contains(product)) {
            throw new IllegalArgumentException();
        }
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("#Category: %s\n", name));
        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(System.getProperty("line.separator"));
        }
        return strBuilder.toString();
    }
}
