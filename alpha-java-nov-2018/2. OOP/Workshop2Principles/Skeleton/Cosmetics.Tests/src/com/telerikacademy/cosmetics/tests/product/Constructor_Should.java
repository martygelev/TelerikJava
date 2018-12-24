package com.telerikacademy.cosmetics.tests.product;

import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.UsageType;
import com.telerikacademy.cosmetics.models.products.ShampooImpl;
import com.telerikacademy.cosmetics.models.products.ToothpasteImpl;
import org.junit.Test;

public class Constructor_Should {
    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheNameIsNull() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl(null, "brand", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheBrandIsNull() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", null, 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("n", "brand", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("01234567890", "brand", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheBrandIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", "b", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheBrandIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", "01234567890", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenPriceIsNegative() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", "brand", -1, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test
    public void createShampooWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        ShampooImpl shampoo = new ShampooImpl("name", "brand", 10, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullIngredientsArePassed() {
        // Arrange, Act, Assert
        ToothpasteImpl shampoo = new ToothpasteImpl("name", "brand", 10, GenderType.WOMEN, null);
    }

    @Test
    public void createToothpasteWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        ToothpasteImpl shampoo = new ToothpasteImpl("name", "brand", 10, GenderType.WOMEN, "ingredients");
    }
}