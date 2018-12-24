package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.core.contracts.CosmeticsFactory;
import com.telerikacademy.cosmetics.models.cart.ShoppingCartImpl;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.UsageType;
import com.telerikacademy.cosmetics.models.contracts.*;
import com.telerikacademy.cosmetics.models.products.ShampooImpl;
import com.telerikacademy.cosmetics.models.products.ToothpasteImpl;

import java.util.List;

public class CosmeticsFactoryImpl implements CosmeticsFactory {
    @Override
    public Category createCategory(String name) {
        return null;
    }

    @Override
    public ShampooImpl createShampoo(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        return null;
    }

    @Override
    public ToothpasteImpl createToothpaste(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        return null;
    }

    @Override
    public ShoppingCartImpl createShoppingCart() {
        return null;
    }
}
