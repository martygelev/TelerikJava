package com.telerikacademy.cosmetics.cli;

import com.telerikacademy.cosmetics.core.engine.CosmeticsEngine;
import com.telerikacademy.cosmetics.models.Category;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class Startup {

    public static void main(String[] args) {
       CosmeticsEngine.getInstance().start();

//        String n = "bn";
//        GenderType.valueOf(n);

//        Category c = new Category("test");
//
//        Product product = new Product("name", "brand", 10, GenderType.MEN);
//        Product asd = new Product("asd", "brand1", 100, GenderType.MEN);
//        Product foo = new Product("foo", "brand", 120, GenderType.MEN);
//
//        Product bar = new Product("baar", "bar", 10, GenderType.MEN);
//
//        c.addProduct(product);
//        c.addProduct(asd);
//        c.addProduct(foo);
//        c.addProduct(bar);
//
//        System.out.println(Arrays.toString(c.getProducts().toArray()));
    }
}
