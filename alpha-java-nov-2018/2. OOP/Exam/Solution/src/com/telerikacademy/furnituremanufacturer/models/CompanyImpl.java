package com.telerikacademy.furnituremanufacturer.models;

import com.telerikacademy.furnituremanufacturer.interfaces.Company;
import com.telerikacademy.furnituremanufacturer.interfaces.Furniture;

import java.util.ArrayList;
import java.util.List;

public class CompanyImpl implements Company {
    private static final int NAME_MIN_LENGTH = 5;
    private static final int EXACT_REGISTRATION_NUMBER_LENGTH = 10;
    // Finish the class

    private String name;
    private String registrationNumber;
    private List<Furniture> furnitures;

    public CompanyImpl(String name, String registrationNumber)
    {
        setName(name);
        setRegistrationNumber(registrationNumber);
        furnitures = new ArrayList<>();
    }

    private void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null) {
            throw new IllegalArgumentException();
        }
        if (registrationNumber.length() != EXACT_REGISTRATION_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
        if (!registrationNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
        this.registrationNumber = registrationNumber;
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public List<Furniture> getFurnitures(){
        return furnitures;
    }

    public void add(Furniture furniture) {
        if (furniture == null) {
            throw new IllegalArgumentException();
        }
        furnitures.add(furniture);
    }

    public String catalog()
    {
        StringBuilder strBuilder = new StringBuilder();
        //todo check this again
        String numberOfFurnituresOrNo = furnitures.isEmpty() ? "no" : String.format("%d", furnitures.size());
        String singleOrPlural = furnitures.size() == 1 ? "furniture" : "furnitures";

        strBuilder.append(String.format("%s - %s - %s %s", name, registrationNumber, numberOfFurnituresOrNo, singleOrPlural));
        strBuilder.append(System.lineSeparator());

        furnitures.sort((x1, x2) -> {
            int compareResult = (int) (x1.getPrice() - x2.getPrice());
            if (compareResult == 0) {
                compareResult = x1.getModel().compareTo(x2.getModel());
            }
            return compareResult;
        });

        for (Furniture furniture : furnitures) {
            strBuilder.append(furniture.toString().trim());
            strBuilder.append(System.lineSeparator());
        }

        return strBuilder.toString().trim();
    }

    public Furniture find(String model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }

        return furnitures.stream()
                .filter(x -> x.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);
    }

    public void remove(Furniture furniture) {
        if (furniture == null) {
            throw new IllegalArgumentException();
        }

        furnitures.remove(furniture);
    }
}
