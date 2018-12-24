package com.telerikacademy.cosmetics.tests.category;

import com.telerikacademy.cosmetics.models.Category;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;

public class Constructor_Should {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheNameIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Category category = new Category("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ThrowWhenTheNameIsLargerThanMaxValue() {
        // Arrange, Act, Assert
        Category category = new Category("1234567890123456");
    }

    @Test
    public void CreateCategoryWhenNameIsValid() {
        // Arrange, Act
        Category category = new Category("test");

        // Assert
        Assert.assertThat(category, instanceOf(Category.class));
    }

    @Test
    public void InitializeNewListOfProductsWhenCategoryIsCreated() {
        // Arrange, Act

        Category category = new Category("test");

        // Assert
        Assert.assertNotNull(category.getProducts());
    }

}
