package com.telerikacademy.cosmetics.tests.category;

import com.telerikacademy.cosmetics.models.Category;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.products.Product;
import org.junit.*;

public class AddProduct_Should {
    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheProductIsNull() {
        // Arrange, Act
        Category category = new Category("test");

        // Act, Assert
        category.addProduct(null);
    }

    @Test
    public void AddProductWhenProductIsValid() {
        // Arrange
        Category category = new Category("test");
        Product productToAdd = new Product("name", "brand", 10, GenderType.MEN);

        // Act
        category.addProduct(productToAdd);
        category.addProduct(productToAdd);

        //Assert
        Assert.assertEquals(2, category.getProducts().size());
    }
}

