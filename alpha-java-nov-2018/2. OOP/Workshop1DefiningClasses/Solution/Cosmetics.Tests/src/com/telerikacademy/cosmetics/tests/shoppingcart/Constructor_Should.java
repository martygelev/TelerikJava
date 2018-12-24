package com.telerikacademy.cosmetics.tests.shoppingcart;

import com.telerikacademy.cosmetics.models.cart.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class Constructor_Should {
   @Test
    public void InitializeNewListOfProductsWhenCategoryIsCreated()
    {
        // Arrange, Act
        ShoppingCart cart = new ShoppingCart();

        // Assert
        Assert.assertNotNull(cart.getProductList());
    }

}
