package com.telerikacademy.cosmetics.models.cart;

import com.telerikacademy.cosmetics.models.contracts.Product;
import com.telerikacademy.cosmetics.models.contracts.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {
    private List<Product> productList;

    public ShoppingCartImpl() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        productList.add(product);
    }

    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        productList.remove(product);
    }

    public boolean containsProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        return productList.contains(product);
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
