package com.telerikacademy.furnituremanufacturer.interfaces;

import java.util.List;

public interface Company {

    String getName();

    String getRegistrationNumber();

    List<Furniture> getFurnitures();

    void add(Furniture furniture);

    void remove(Furniture furniture);

    Furniture find(String model);

    String catalog();
}
