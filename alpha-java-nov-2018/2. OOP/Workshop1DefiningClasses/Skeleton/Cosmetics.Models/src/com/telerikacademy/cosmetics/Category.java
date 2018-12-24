package com.telerikacademy.cosmetics;

import com.telerikacademy.cosmetics.products.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Category {
    private String name;
    private List<Product> products;

    public Category(String name) {
    }

    public List<Product> getProducts() {
        throw new NotImplementedException();
    }

    public void addProduct(Product product) {
        throw new NotImplementedException();
    }

    public void removeProduct(Product product) {
        throw new NotImplementedException();
    }

    public String print() {
        StringBuilder strBuilder = new StringBuilder();

        for (Product product : products) {
            strBuilder.append(product.print());
            strBuilder.append(System.getProperty("line.separator"));
        }

        throw new NotImplementedException();
    }
}
