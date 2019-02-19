package com.telerikacademy.furnituremanufacturer.engine.factories;

import com.telerikacademy.furnituremanufacturer.interfaces.Company;
import com.telerikacademy.furnituremanufacturer.interfaces.engine.CompanyFactory;
import com.telerikacademy.furnituremanufacturer.models.CompanyImpl;

public class CompanyFactoryImpl implements CompanyFactory {

    @Override
    public Company createCompany(String name, String registrationNumber) {
        return new CompanyImpl(name, registrationNumber);
    }
}
