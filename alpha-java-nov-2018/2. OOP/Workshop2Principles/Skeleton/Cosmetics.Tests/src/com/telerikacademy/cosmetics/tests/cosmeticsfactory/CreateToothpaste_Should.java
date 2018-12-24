package com.telerikacademy.cosmetics.tests.cosmeticsfactory;

import com.telerikacademy.cosmetics.core.engine.CosmeticsFactoryImpl;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.contracts.Product;
import com.telerikacademy.cosmetics.models.products.ToothpasteImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CreateToothpaste_Should {
    @Test
    public void returnInstanceOfTypeProduct() {
        // Arrange
        CosmeticsFactoryImpl factory = new CosmeticsFactoryImpl();
        // Act
        ToothpasteImpl toothpaste = factory.createToothpaste("name", "brand", 10, GenderType.UNISEX, new ArrayList<>());
        // Assert
        Assert.assertTrue(toothpaste instanceof Product);
    }
}
