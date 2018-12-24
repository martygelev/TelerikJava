package com.telerikacademy.furnituremanufacturer.engine;

public class EngineConstants {

    // Commands
     static final String CreateCompanyCommand = "CreateCompany";
     static final String AddFurnitureToCompanyCommand = "AddFurnitureToCompany";
     static final String RemoveFurnitureFromCompanyCommand = "RemoveFurnitureFromCompany";
     static final String FindFurnitureFromCompanyCommand = "FindFurnitureFromCompany";
     static final String ShowCompanyCatalogCommand = "ShowCompanyCatalog";
     static final String CreateTableCommand = "CreateTable";
     static final String CreateChairCommand = "CreateChair";
     static final String SetChairHeight = "SetChairHeight";
     static final String ConvertChair = "ConvertChair";

    // Chair types
     static final String NormalChairType = "Normal";
     static final String AdjustableChairType = "Adjustable";
     static final String ConvertibleChairType = "Convertible";

    // Error messages
     static final String InvalidCommandErrorMessage = "Invalid command name: %s";
     static final String CompanyExistsErrorMessage = "Company %s already exists";
     static final String CompanyNotFoundErrorMessage = "Company %s not found";
     static final String FurnitureNotFoundErrorMessage = "Furniture %s not found";
     static final String FurnitureExistsErrorMessage = "Furniture %s already exists";
     static final String InvalidChairTypeErrorMessage = "Invalid chair type: %s";
     static final String FurnitureIsNotAdjustableChairErrorMessage = "%s is not adjustable chair";
     static final String FurnitureIsNotConvertibleChairErrorMessage = "%s is not convertible chair";

    // Success messages
     static final String CompanyCreatedSuccessMessage = "Company %s created";
     static final String FurnitureAddedSuccessMessage = "Furniture %s added to company %s";
     static final String FurnitureRemovedSuccessMessage = "Furniture %s removed from company %s";
     static final String TableCreatedSuccessMessage = "Table %s created";
     static final String ChairCreatedSuccessMessage = "Chair %s created";
     static final String ChairHeightAdjustedSuccessMessage = "Chair %s adjusted to height %.2f";
     static final String ChairStateConvertedSuccessMessage = "Chair %s converted";
}
