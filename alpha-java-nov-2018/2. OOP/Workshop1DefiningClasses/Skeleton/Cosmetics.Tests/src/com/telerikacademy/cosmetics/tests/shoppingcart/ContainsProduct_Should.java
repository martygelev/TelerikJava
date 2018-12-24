package com.telerikacademy.cosmetics.tests.shoppingcart;

import com.telerikacademy.cosmetics.cart.ShoppingCart;
import com.telerikacademy.cosmetics.common.GenderType;
import com.telerikacademy.cosmetics.products.Product;
import org.junit.Assert;
import org.junit.Test;

public class ContainsProduct_Should {
    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();

        // Act, Assert
        cart.containsProduct(null);
    }

    @Test
    public void ReturnTrueWhenProductIFound() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);
        cart.addProduct(productToAdd);
        cart.addProduct(productToAdd);

        // Act
        boolean isFound = cart.containsProduct(productToAdd);

        //Assert
        Assert.assertTrue(isFound);
    }

    @Test
    public void ReturnFalseWhenProductIFound() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);

        // Act
        boolean isFound = cart.containsProduct(productToAdd);

        //Assert
        Assert.assertFalse(isFound);
    }

}
