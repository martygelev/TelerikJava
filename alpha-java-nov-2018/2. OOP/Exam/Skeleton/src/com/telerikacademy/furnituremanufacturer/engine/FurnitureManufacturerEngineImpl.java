package com.telerikacademy.furnituremanufacturer.engine;

import com.telerikacademy.furnituremanufacturer.engine.factories.CompanyFactoryImpl;
import com.telerikacademy.furnituremanufacturer.engine.factories.FurnitureFactoryImpl;
import com.telerikacademy.furnituremanufacturer.interfaces.*;
import com.telerikacademy.furnituremanufacturer.interfaces.engine.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FurnitureManufacturerEngineImpl implements FurnitureManufacturerEngine {



    private static FurnitureManufacturerEngine instance;

    private CompanyFactory companyFactory;
    private FurnitureFactory furnitureFactory;

    private Map<String, Company> companies;
    private Map<String, Furniture> furnitures;

    private Renderer renderer;

    private FurnitureManufacturerEngineImpl()
    {
        companyFactory = new CompanyFactoryImpl();
        furnitureFactory = new FurnitureFactoryImpl();
        companies = new HashMap<>();
        furnitures = new HashMap<>();
        renderer = new ConsoleRendererImpl();
    }

    public static FurnitureManufacturerEngine instanceInit() {

        if (instance == null) {
            instance = new FurnitureManufacturerEngineImpl();
        }
        return instance;
    }

    @Override
    public void start() {
        List<String> commandResults = new ArrayList<>();
        try
        {
            List<Command> commands = readCommands();
            commandResults = processCommands(commands);
        }
        catch (Exception ex)
        {
            commandResults.add(ex.getMessage());
        }

        renderCommandResults(commandResults);
    }

    private List<Command> readCommands() {

        List<Command> commands = new ArrayList<>();

        for ( String currentLine : renderer.input()){
            Command currentCommand = CommandImpl.parse(currentLine);
            commands.add(currentCommand);
        }
        return commands;
    }

    private List<String> processCommands(List<Command> commands)
    {
        List<String> commandResults = new ArrayList<>();

        for (Command command : commands)
        {
            String commandResult;

            switch (command.getName())
            {
                case EngineConstants.CreateCompanyCommand:
                    String companyName = command.getParameters().get(0);
                    String companyRegistrationNumber = command.getParameters().get(1);
                    commandResult = createCompany(companyName, companyRegistrationNumber);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.AddFurnitureToCompanyCommand:
                    String companyToAddTo = command.getParameters().get(0);
                    String furnitureToBeAdded = command.getParameters().get(1);
                    commandResult = addFurnitureToCompany(companyToAddTo, furnitureToBeAdded);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.RemoveFurnitureFromCompanyCommand:
                    String companyToRemoveFrom = command.getParameters().get(0);
                    String furnitureToBeRemoved = command.getParameters().get(1);
                    commandResult = removeFurnitureFromCompany(companyToRemoveFrom, furnitureToBeRemoved);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.FindFurnitureFromCompanyCommand:
                    String companyToFindFrom = command.getParameters().get(0);
                    String furnitureToBeFound = command.getParameters().get(1);
                    commandResult = findFurnitureFromCompany(companyToFindFrom, furnitureToBeFound);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.ShowCompanyCatalogCommand:
                    String companyToShowCatalog = command.getParameters().get(0);
                    commandResult = showCompanyCatalog(companyToShowCatalog);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.CreateTableCommand:
                    String tableModel = command.getParameters().get(0);
                    String tableMaterial = command.getParameters().get(1);
                    double tablePrice = Double.parseDouble(command.getParameters().get(2));
                    double tableHeight = Double.parseDouble(command.getParameters().get(3));
                    double tableLength = Double.parseDouble(command.getParameters().get(4));
                    double tableWidth = Double.parseDouble(command.getParameters().get(5));
                    commandResult = createTable(tableModel, tableMaterial, tablePrice, tableHeight, tableLength, tableWidth);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.CreateChairCommand:
                    String chairModel = command.getParameters().get(0);
                    String chairMaterial = command.getParameters().get(1);
                    double chairPrice = Double.parseDouble(command.getParameters().get(2));
                    double chairHeight = Double.parseDouble(command.getParameters().get(3));
                    int chairLegs = Integer.parseInt(command.getParameters().get(4));
                    String chairType = command.getParameters().get(5);
                    commandResult = createChair(chairModel, chairMaterial, chairPrice, chairHeight, chairLegs, chairType);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.SetChairHeight:
                    String adjChairModel = command.getParameters().get(0);
                    double adjChairHeight = Double.parseDouble(command.getParameters().get(1));
                    commandResult = adjustChairHeight(adjChairModel, adjChairHeight);
                    commandResults.add(commandResult);
                    break;
                case EngineConstants.ConvertChair:
                    String convertibleChairModel = command.getParameters().get(0);
                    commandResult = convertChair(convertibleChairModel);
                    commandResults.add(commandResult);
                    break;
                default:
                    commandResults.add(String.format(EngineConstants.InvalidCommandErrorMessage, command.getName()));
                    break;
            }
        }

        return commandResults;
    }

    private void renderCommandResults(List<String> output)
    {
        renderer.output(output);
    }

    private String createCompany(String name, String registrationNumber)
    {
        if (companies.containsKey(name))
        {
            return String.format(EngineConstants.CompanyExistsErrorMessage, name);
        }

        Company company = companyFactory.createCompany(name, registrationNumber);
        companies.put(name, company);

        return String.format(EngineConstants.CompanyCreatedSuccessMessage, name);
    }

    private String addFurnitureToCompany(String companyName, String furnitureName)
    {
        if (!companies.containsKey(companyName))
        {
            return String.format(EngineConstants.CompanyNotFoundErrorMessage, companyName);
        }

        if (!furnitures.containsKey(furnitureName))
        {
            return String.format(EngineConstants.FurnitureNotFoundErrorMessage, furnitureName);
        }

        Company company = companies.get(companyName);
        Furniture furniture = furnitures.get(furnitureName);
        company.add(furniture);

        return String.format(EngineConstants.FurnitureAddedSuccessMessage, furnitureName, companyName);
    }

    private String removeFurnitureFromCompany(String companyName, String furnitureName)
    {
        if (!this.companies.containsKey(companyName))
        {
            return String.format(EngineConstants.CompanyNotFoundErrorMessage, companyName);
        }

        if (!this.furnitures.containsKey(furnitureName))
        {
            return String.format(EngineConstants.FurnitureNotFoundErrorMessage, furnitureName);
        }

        Company company = companies.get(companyName);
        Furniture furniture = furnitures.get(furnitureName);
        company.remove(furniture);

        return String.format(EngineConstants.FurnitureRemovedSuccessMessage, furnitureName, companyName);
    }

    private String findFurnitureFromCompany(String companyName, String furnitureName)
    {
        if (!this.companies.containsKey(companyName))
        {
            return String.format(EngineConstants.CompanyNotFoundErrorMessage, companyName);
        }

        Company company = companies.get(companyName);
        Furniture furniture = company.find(furnitureName);
        if (furniture == null)
        {
            return String.format(EngineConstants.FurnitureNotFoundErrorMessage, furnitureName);
        }

        return furniture.toString();
    }

    private String showCompanyCatalog(String companyName)
    {
        if (!this.companies.containsKey(companyName))
        {
            return String.format(EngineConstants.CompanyNotFoundErrorMessage, companyName);
        }

        return companies.get(companyName).catalog();
    }

    private String createTable(String model, String material, double price, double height, double length, double width)
    {
        if (this.furnitures.containsKey(model))
        {
            return String.format(EngineConstants.FurnitureExistsErrorMessage, model);
        }

        Furniture table = (Furniture)furnitureFactory.createTable(model, material, price, height, length, width);
        furnitures.put(model, table);

        return String.format(EngineConstants.TableCreatedSuccessMessage, model);
    }

    private String createChair(String model, String material, double price, double height, int legs, String type)
    {
        if (this.furnitures.containsKey(model))
        {
            return String.format(EngineConstants.FurnitureExistsErrorMessage, model);
        }

        Furniture chair;
        switch (type)
        {
            case EngineConstants.NormalChairType:
                chair = (Furniture)furnitureFactory.createChair(model, material, price, height, legs,type);
                break;
            case EngineConstants.AdjustableChairType:
                chair = (Furniture)furnitureFactory.createAdjustableChair(model, material, price, height, legs,type);
                break;
            case EngineConstants.ConvertibleChairType:
                chair = (Furniture)furnitureFactory.createConvertibleChair(model, material, price, height, legs,type);
                break;
            default:
                return String.format(EngineConstants.InvalidChairTypeErrorMessage, type);
        }

        furnitures.put(model, chair);

        return String.format(EngineConstants.ChairCreatedSuccessMessage, model);
    }

    private String adjustChairHeight(String model, double height)
    {
        if (!this.furnitures.containsKey(model))
        {
            return String.format(EngineConstants.FurnitureNotFoundErrorMessage, model);
        }

        AdjustableChair adjChair = (AdjustableChair)furnitures.get(model);
        if (adjChair == null)
        {
            return String.format(EngineConstants.FurnitureIsNotAdjustableChairErrorMessage, model);
        }

        adjChair.setHeight(height);

        return String.format(EngineConstants.ChairHeightAdjustedSuccessMessage, model, height);
    }

    private String convertChair(String model)
    {
        if (!this.furnitures.containsKey(model))
        {
            return String.format(EngineConstants.FurnitureNotFoundErrorMessage, model);
        }

        Chair check = (Chair) furnitures.get(model);
        if (!check.getChairType().toString().equals("Convertible"))
        {
            return String.format(EngineConstants.FurnitureIsNotConvertibleChairErrorMessage,model);
        }

        ConvertibleChair convChair = (ConvertibleChair) furnitures.get(model);
        if (convChair == null)
        {
            return String.format(EngineConstants.FurnitureIsNotConvertibleChairErrorMessage, model);
        }



        convChair.convert();

        return String.format(EngineConstants.ChairStateConvertedSuccessMessage, model);
    }
}