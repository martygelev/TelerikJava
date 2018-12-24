package com.telerikacademy.cosmetics.tests.shoppingcart;

import com.telerikacademy.cosmetics.cart.ShoppingCart;
import com.telerikacademy.cosmetics.common.GenderType;
import com.telerikacademy.cosmetics.products.Product;
import org.junit.Assert;
import org.junit.Test;

public class AddProduct_Should {
    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();

        // Act, Assert
        cart.addProduct(null);
    }

    @Test
    public void AddProductWhenProductIsValid() {
        // Arrange
        ShoppingCart cart = new ShoppingCart();
        // Arrange, Act
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);

        // Act
        cart.addProduct(productToAdd);
        cart.addProduct(productToAdd);

        //Assert
        Assert.assertEquals(2, cart.getProductList().size());
    }

}
