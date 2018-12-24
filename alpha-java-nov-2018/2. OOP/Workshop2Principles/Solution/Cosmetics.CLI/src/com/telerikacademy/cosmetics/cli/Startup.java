package com.telerikacademy.cosmetics.cli;

import com.telerikacademy.cosmetics.core.engine.CosmeticsEngine;

public class Startup {

    public static void main(String[] args) {
        CosmeticsEngine.getInstance().start();
    }
}
