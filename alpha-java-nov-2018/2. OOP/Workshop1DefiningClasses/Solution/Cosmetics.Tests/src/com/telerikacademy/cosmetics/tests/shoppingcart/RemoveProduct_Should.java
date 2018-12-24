package com.telerikacademy.cosmetics.tests.shoppingcart;

import com.telerikacademy.cosmetics.models.cart.ShoppingCart;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.products.Product;
import org.junit.Assert;
import org.junit.Test;

public class RemoveProduct_Should {
    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();

        // Act, Assert
        cart.removeProduct(null);
    }

    @Test
    public void RemoveProductWhenProductIsValid() {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);;

        cart.addProduct(productToAdd);
        cart.addProduct(productToAdd);

        // Act
        cart.removeProduct(productToAdd);

        //Assert
        Assert.assertEquals(1, cart.getProductList().size());
    }

}
