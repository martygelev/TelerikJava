package com.telerikacademy.cosmetics.cart;

import com.telerikacademy.cosmetics.products.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart() {
    }

    public List<Product> getProductList() {
        return new ArrayList<Product>(productList);
    }

    public void addProduct(Product product) {
        throw new NotImplementedException();
    }

    public void removeProduct(Product product) {
        throw new NotImplementedException();
    }

    public boolean containsProduct(Product product) {
        throw new NotImplementedException();
    }

    public double totalPrice() {
        throw new NotImplementedException();
    }
}
