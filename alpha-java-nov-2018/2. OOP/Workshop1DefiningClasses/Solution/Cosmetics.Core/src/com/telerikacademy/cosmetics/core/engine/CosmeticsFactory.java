package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.models.Category;
import com.telerikacademy.cosmetics.models.cart.ShoppingCart;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.products.Product;

public class CosmeticsFactory {
    public Category CreateCategory(String name) {
        return new Category(name);
    }

    public Product CreateProduct(String name, String brand, double price, String gender) {
        return new Product(name, brand, price, GenderType.valueOf(gender));
    }

    public ShoppingCart ShoppingCart() {
        return new ShoppingCart();
    }
}
