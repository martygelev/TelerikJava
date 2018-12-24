package com.telerikacademy.cosmetics.tests.cosmeticsfactory;

import com.telerikacademy.cosmetics.core.engine.CosmeticsFactoryImpl;
import com.telerikacademy.cosmetics.models.cart.ShoppingCartImpl;
import com.telerikacademy.cosmetics.models.contracts.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class CreateShoppingCart_Should {
    @Test
    public void returnInstanceOfTypeShoppingCart() {
        // Arrange, Act, Assert
        CosmeticsFactoryImpl factory = new CosmeticsFactoryImpl();

        // Act
        ShoppingCartImpl cart = factory.createShoppingCart();

        // Assert
        Assert.assertTrue(cart instanceof ShoppingCart);
    }
}
