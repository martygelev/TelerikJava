package com.telerikacademy.cosmetics.tests.product;

import com.telerikacademy.cosmetics.common.GenderType;
import com.telerikacademy.cosmetics.products.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class Constructor_Should {
    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Product productToAdd = new Product("1", "brand", 10, GenderType.MEN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Product productToAdd = new Product("12345678901", "brand", 10, GenderType.MEN);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheBrandIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Product productToAdd = new Product("name", "b", 10, GenderType.MEN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheBrandIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Product productToAdd = new Product("name", "12345678901", 10, GenderType.MEN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenPriceIsNegative() {
        // Arrange, Act, Assert
        Product productToAdd = new Product("name", "brand", -1, GenderType.MEN);
    }

    @Test
    public void CreateProductWhenValidValuesArePassed() {
        // Arrange, Act
        Product product = new Product("name", "brand", 10, GenderType.MEN);

        // Assert
        Assert.assertThat(product, instanceOf(Product.class));
    }
}