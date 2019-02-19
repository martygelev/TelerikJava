package com.telerikacademy.furnituremanufacturer.interfaces.engine;

import com.telerikacademy.furnituremanufacturer.interfaces.Company;

public interface CompanyFactory {

    Company createCompany(String name, String registrationNumber);
}
