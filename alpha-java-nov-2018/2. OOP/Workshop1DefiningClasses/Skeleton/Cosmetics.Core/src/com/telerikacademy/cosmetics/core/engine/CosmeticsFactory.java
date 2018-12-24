package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.Category;
import com.telerikacademy.cosmetics.cart.ShoppingCart;
import com.telerikacademy.cosmetics.products.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CosmeticsFactory {
    public Category CreateCategory(String name)
    {
        return new Category(name);
    }

    public Product CreateProduct(String name, String brand, double price, String gender)
    {
        throw new NotImplementedException();
    }

    public ShoppingCart ShoppingCart()
    {
        return new ShoppingCart();
    }
}
