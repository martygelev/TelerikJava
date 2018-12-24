package com.telerikacademy.furnituremanufacturer.models;

import com.telerikacademy.furnituremanufacturer.interfaces.Company;
import com.telerikacademy.furnituremanufacturer.interfaces.Furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyImpl implements Company {
    private static final String COMPANY_NAME_NULL_MESSAGE = "Company name cannot be null";
    private static final String COMPANY_NAME_MIN_LENGTH_MESSAGE = "Company name cannot be less than 5 symbols";
    private static final int MIN_COMPANY_NAME_LENGTH = 5;
    private static final int EXACT_REGISTRATION_NUMBER_LENGTH =10;

    private String name;
    private String registrationNumber;
    private List<Furniture> furnitures;

    //TODO

    public CompanyImpl(String name, String registrationNumber){
        setName(name);
        setRegistrationNumber(registrationNumber);
        furnitures=new ArrayList<>();
    }

    private void setName(String name) {
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException(COMPANY_NAME_NULL_MESSAGE);
        }
        if (name.length()<MIN_COMPANY_NAME_LENGTH)
        {
            throw new IllegalArgumentException(COMPANY_NAME_MIN_LENGTH_MESSAGE);
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
        furnitures.sort((x1, x2) -> {
            int compareResult = (int) (x1.getPrice() - x2.getPrice());
            if (compareResult == 0) {
                compareResult = x1.getModel().compareTo(x2.getModel());
            }
            return compareResult;
        });
        return furnitures;
    }

    public void add(Furniture furniture)
    {
        furnitures.add(furniture);
    }

    private void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber.length() != EXACT_REGISTRATION_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
        if (!registrationNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
        this.registrationNumber = registrationNumber;
    }

    public String catalog()
    {
        if (furnitures==null || furnitures.isEmpty()){
            return String.format("%s - %s - no furnitures",this.getName(),this.getRegistrationNumber());
        }

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(this.getName())
                .append(" - ")
                .append(this.getRegistrationNumber())
                .append(" - ")
                .append(furnitures.size())
                .append(furnitures.size()==1 ? " furniture" : " furnitures")
                .append(System.lineSeparator())
                .append(getFurnitures().stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining("\n")));

        return strBuilder.toString().trim();
    }

    public Furniture find(String model)
    {
       return furnitures.stream()
                .filter(x -> x.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);
    }

    public void remove(Furniture furniture)
    {
        furnitures.remove(furniture);
    }
}
