package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.core.contracts.CosmeticsFactory;
import com.telerikacademy.cosmetics.models.CategoryImpl;
import com.telerikacademy.cosmetics.models.cart.ShoppingCartImpl;
import com.telerikacademy.cosmetics.models.common.*;
import com.telerikacademy.cosmetics.models.contracts.*;
import com.telerikacademy.cosmetics.models.products.*;

import java.util.List;

public class CosmeticsFactoryImpl implements CosmeticsFactory {
    @Override
    public Category createCategory(String name) {
        return new CategoryImpl(name);
    }

    @Override
    public Shampoo createShampoo(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        return new ShampooImpl(name, brand, price, gender, milliliters, usage);
    }

    @Override
    public Toothpaste createToothpaste(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        return new ToothpasteImpl(name, brand, price, gender, String.join(",", ingredients));
    }

    @Override
    public Cream createCream(String name, String brand, double price, GenderType gender, ScentType scent) {
        return new CreamImpl(name, brand, price, gender, scent);
    }

    @Override
    public ShoppingCart createShoppingCart() {
        return new ShoppingCartImpl();
    }
}
