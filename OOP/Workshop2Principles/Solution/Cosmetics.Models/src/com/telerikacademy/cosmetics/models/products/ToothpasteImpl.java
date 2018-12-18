package com.telerikacademy.cosmetics.models.products;

import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.contracts.Toothpaste;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private String ingredients;

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, String ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    @Override
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException();
        }
        this.ingredients = ingredients;
    }

    @Override
    public String print() {
        return String.format("%s\n" +
                " #Ingredients: %s\n" +
                " ===", super.print(), ingredients);
    }
}
