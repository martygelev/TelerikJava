package com.telerikacademy.cosmetics.tests.category;

import com.telerikacademy.cosmetics.Category;
import com.telerikacademy.cosmetics.common.GenderType;
import com.telerikacademy.cosmetics.products.Product;
import org.junit.*;

public class RemoveProduct_Should {

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        Category category = new Category("test");

        // Act, Assert
        category.removeProduct(null);
    }

    @Test
    public void RemoveProductWhenProductIsValid() {
        // Arrange, Act
        Category category = new Category("name");
        Product productToRemove = new Product("name", "brand", 10, GenderType.MEN);
        category.addProduct(productToRemove);
        category.addProduct(productToRemove);

        // Act
        category.removeProduct(productToRemove);

        //Assert
        Assert.assertEquals(1, category.getProducts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenProductNotFound() {
        // Arrange, Act
        Category category = new Category("name");
        Product productToRemove = new Product("name", "brand", 10, GenderType.MEN);

        // Act, Assert
        category.removeProduct(productToRemove);
    }
}
