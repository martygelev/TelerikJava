package com.telerikacademy.cosmetics.tests.cosmeticsfactory;

import com.telerikacademy.cosmetics.core.engine.CosmeticsFactoryImpl;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.UsageType;
import com.telerikacademy.cosmetics.models.contracts.Product;
import com.telerikacademy.cosmetics.models.products.ShampooImpl;
import org.junit.Assert;
import org.junit.Test;

public class CreateShampoo_Should {
    @Test
    public void returnInstanceOfTypeProduct() {
        // Arrange
        CosmeticsFactoryImpl factory = new CosmeticsFactoryImpl();
        // Act
        ShampooImpl shampoo = factory.createShampoo("name", "brand", 10, GenderType.UNISEX, 10, UsageType.EVERY_DAY);
        // Assert
        Assert.assertTrue(shampoo instanceof Product);
    }
}
