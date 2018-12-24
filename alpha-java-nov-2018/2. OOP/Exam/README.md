## Furniture Factory - workshop (OOP - Final)

The Furniture factory already has a working Engine. You do not have to touch anything in it. Just use it.

A furniture manufacturer keeps track of their companies and furniture: tables and chairs. 
- Each furniture piece has **model, material, price in dollars, and height in meters**. 
- Each table has **length and width in meters**. 
- Chairs are three types: **normal, adjustable and convertible**. 
  - Each chair has number of legs. 
  - Each adjustable chair can adjust its height. 
  - Each convertible chair can convert its state and be easily movable. 
- Each company has **name, registration number and catalog of furniture**. Companies can add or remove furniture to their catalogs. Companies can find furniture by model. Companies can show catalogs of all furniture they offer. 

### Design the Class Hierarchy
Your task is to design an object-oriented class hierarchy to model the Furniture Factory, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Avoid duplicated code though abstraction, inheritance, and polymorphism and encapsulate correctly all fields.
You are given few Java interfaces that you should obligatory implement and use as a basis of your code:

```java
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

import com.telerikacademy.furnituremanufacturer.models.MaterialType;

public interface Furniture {

    String getModel();

    MaterialType getMaterialType();

    double getPrice();

    double getHeight();
}

public interface Chair {

    int getNumberOfLegs();
}

public interface Table {

    double getLength();

    double getWidth();

    double getArea();
}

public interface AdjustableChair {

    void setHeight(double height);
}

public interface ConvertibleChair {

    boolean getIsConverted();

    void convert();
}
```

- All your furniture should implement Furniture. (think how to do it, use inheritance)
- Tables should implement Table
- Chairs should implement Chair, adjustable chairs should implement AdjustableChair and convertible chairs should implement ConvertibleChair. 
- Companies should implement Company.

### Validation
- Furniture
  - Model cannot be empty, null or with **less than 3 symbols**.
  - Price cannot be **less or equal to 0.00**.
  -	Height cannot be **less or equal to 0.00**.
- Table validity rules:
    - Can calculate area by the following formula: **length * width**.
- Adjustable chair validity rules:
    - Can change the height to a new valid one. 
- Convertible chair validity rules:
    - Has too states – **converted and normal**.
    - States can be changed by converting the chair from one to another.
    - Converted state sets **the height to 0.10**.
    - Normal state returns **the height to the initial one**.
    - Initial state is **normal**.
- Company validity rules:
    - Name cannot be empty, null or **with less than 5 symbols**.
    - Registration number must be **exactly 10 symbols and must contain only digits**. 
    - Adding duplicate furniture is allowed.
    - Removing furniture removes **the first occurrence**. If such is not found, **nothing happens**.
    - Finding furniture by model gets **the first occurrence**. If such is not found, return null. **Searching is case insensitive**.
- Companies should only be created through the CompanyFactory implemented by a class named CompanyFactoryImpl.
- Furniture should only be created through the FurnitureFactory implemented by a class named
  - FurnitureFactoryImpl. Both classes are in the package com.telerikacademy.furnituremanufacturer.engine.factories;
- The company catalog method returns the information about the available furniture in the following form:

```
(company name) – (number of furniture as digit example: "5" or ”no”) (“furniture”/”furnitures”) // see example input and output below
(information about furniture)
(information about furniture)
(information about furniture)
```

- The listed furniture added to a certain company (through the add(…) method) must be **ordered by price then by model**. 
  - If the company has no furniture added, print “no furnitures” (**yes, “furnitures” is not a valid word, these are the client's requirements**).
  - If the company has 1 piece of furniture, print “1 furniture” and show its information on a separate line. - If the company has more than 1 piece of furniture, print its number and list each one’s information on a separate line. 
  - Choose:
    - All double type fields should be printed “as is”, without any formatting or rounding. 
    - Or use the following formatting: 0.00 for all double values except getArea(). The area should be print in 0.0000 format (This is the printed example output.)


### Printing

- You may use the following for reference:

```
"%s - %s - %s %s",
name,
registrationNumber,
furnitures.isEmpty() ? "no" : String.format("%d", furnitures.size()),
furnitures.size() == 1 ? "furniture" : "furnitures"
```

**Look into the example below to get better understanding of the printing format.**

- The table information should be in the following form:

```
"Type: %s, Model: %s, Material: %s, Price: %.2f, Height: %.2f%s", Length: %.2f, Width: %.2f, Area: %.4f", this.getClass().getSimpleName().replace("Impl", ""), model, materialType, price, height, additionalInfo()
```
- Hint: You may need to split this across different classes! Avoid code duplication. Think about additionalInfo() method - how and where should you implement it? See example output.

- The normal and adjustable chair information should be in the following form:

```
"Type: %s, Model: %s, Material: %s, Price: %.2f, Height: %.2f%s, Legs: %d", this.getClass().getSimpleName().replace("Impl", ""), model, materialType, price, height, additionalInfo(), numberOfLegs
```

- The convertible chair information should be in the following form:

```
"Type: %s, Model: %s, Material: %s, Price: %.2f, Height: %.2f%s, Legs: %d, State: %s", this.getClass().getSimpleName().replace("Impl", ""), model, materialType, price, height, additionalInfo(), numberOfLegs, isConverted ? CONVERTED : NORMAL_POSITION
```

- The Type is either “Table“, or “Chair”, or “AdjustableChair” or “ConvertibleChair”. The convertible chair state is either “Converted” or “Normal”. All double type fields should be printed “as is”, without any formatting or rounding.

- All properties in the above interfaces are mandatory (cannot be null or empty).
- If a null value is passed to some mandatory property, you should use **defensive programming** to prevent unwanted results.


### Additional Notes
To simplify your work there is already working engine that executes a sequence of commands read from the console using the classes and interfaces in your project. Please put your classes in package **com.telerikacademy.furnituremanufacturer.models;**. Implement the **FurnitureFactoryImpl** class in the package **com.telerikacademy.furnituremanufacturer.engine.factories;**.


Current implemented commands the engine supports are:
- **CreateCompany (name) (registration number)** – adds a company with given name and registration number. Duplicate names are not allowed. As a result the command returns “Company (name) created”.
- **AddFurnitureToCompany (company name) (furniture model)** – searches for furniture and adds it to an existing company’s catalog. As a result the command returns “Furniture (furniture model) added to company (company name)”.
- **RemoveFurnitureFromCompany (company name) (furniture model)** – searches for furniture and removes it from an existing company’s catalog. As a result the command returns “Furniture (furniture model) removed from company (company name)”.
- **FindFurnitureFromCompany (company name) (furniture model)** – searches for furniture in an existing company’s catalog. If found the engine prints the furniture’s toString() method.
- **ShowCompanyCatalog (company name)** – searches for a company and invokes it’s catalog() method.
- **CreateTable (model) (material) (price) (height) (length) (width)** – creates a table with given model, material, price, height, length and width. Duplicate models are not allowed. As a result the command returns “Table (model) created”.
- **CreateChair (model) (material) (price) (height) (legs) (type)** – creates a chair by given model, material, price, height, legs and type. Type can be “Normal”, “Adjustable” and “Convertible”. Duplicate models are not allowed. As a result the command returns “Chair (model) created”.
- **SetChairHeight (model) (height)** – searches for a chair by model and sets its height, if the chair is adjustable. As a result the command returns “Chair (model) adjusted to height (height)”.
- **ConvertChair (model)** – searches for a chair by model and converts its state, if the chair is convertible. As a result the command returns “Chair (model) converted”.
In case of invalid operation or error, the engine returns appropriate text messages.



**All commands return appropriate success messages. In case of invalid operation or error, the engine returns appropriate error messages.**


## Step by step guide

**HINT** - **DO NOT** use the whole input as a test. Break it as simple as possible. Maybe one line at a time is very good starting point.

**-1.** The classes are there. Use them with caution.

**0.** Implement all the interfaces. 

- Look at the "contracts" folder and decide how to use any of the interfaces there.

**1.** General Hints

- You need to override toString() in order to output the classes in the console.

**2.** You are given a skeleton of the Furniture Factory. Please take a look at it carefully before you try to do anything. Try to understand all the classes and interfaces and how the engine works. (You do not need to touch the engine at all).

**3.** Just build the project and look at the errors.
  - **HINT** implement the classes 
  - You already know how to do it. Use inheritance.
  - There is already a class called FurnitureImpl. How this could help you? (base class maybe)

**4.** Are there any other inheritance options? Do you have repeating code in more than one class?
  - Maybe another base class?

**5.** Take a look at the FurnitureFactoryImpl class
  - Is there an interface we could implement?

**6.** How we can validate the that the string passed is a valid enum defined in our solution
  - Look inside FurnitureFactoryImpl class and use the method below

```java
private MaterialType getMaterialType(String material)
    {
        switch (material)
        {
            case WOODEN:
                return MaterialType.WOODEN;
            case LEATHER:
                return MaterialType.LEATHER;
            case PLASTIC:
                return MaterialType.PLASTIC;
            default:
                throw new IllegalArgumentException(String.format(INVALID_MATERIAL_NAME, material));
        }
    }
```




**7.** Validate all properties according to the guidelines set above

**HINT** on how to validate the company's registration number

```java
        if (registrationNumber.length() != EXACT_REGISTRATION_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
        if (!registrationNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Registration number is not valid");
        }
```

**8.** Implement the methods inside the CompanyImpl class
  - Here is how to get first or default item from collection and how to compare two items and sort collection

```java
Furniture item = furnitures.stream()
                .filter(x -> x.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);

furnitures.sort((x1, x2) -> {
            int compareResult = (int) (x1.getPrice() - x2.getPrice());
            if (compareResult == 0) {
                compareResult = x1.getModel().compareTo(x2.getModel());
            }
            return compareResult;
        });
```



### Sample Input

```
CreateCompany FurnitureTelerik 1234567890
ShowCompanyCatalog FurnitureTelerik
CreateTable SmallTable wooden 123.4 0.50 0.45 0.65
CreateChair TestChair leather 99.99 1.20 5 Normal
CreateChair MyChair leather 111.56 0.80 4 Adjustable
CreateChair NewChair plastic 80.00 1.00 3 Convertible
ShowCompanyCatalog FurnitureTelerik
AddFurnitureToCompany FurnitureTelerik SmallTable
AddFurnitureToCompany FurnitureTelerik TestChair
AddFurnitureToCompany FurnitureTelerik MyChair
AddFurnitureToCompany FurnitureTelerik NewChair
ShowCompanyCatalog FurnitureTelerik
RemoveFurnitureFromCompany FurnitureTelerik NewChair
ShowCompanyCatalog FurnitureTelerik
FindFurnitureFromCompany FurnitureTelerik MyChair
FindFurnitureFromCompany FurnitureTelerik NewChair
RemoveFurnitureFromCompany FurnitureTelerik MyChair
RemoveFurnitureFromCompany FurnitureTelerik SmallTable
ShowCompanyCatalog FurnitureTelerik
```

### Sample Output with 0.00 formatting (0.0000 for the area)

```
Company FurnitureTelerik created
FurnitureTelerik - 1234567890 - no furnitures
Table SmallTable created
Chair TestChair created
Chair MyChair created
Chair NewChair created
FurnitureTelerik - 1234567890 - no furnitures
Furniture SmallTable added to company FurnitureTelerik
Furniture TestChair added to company FurnitureTelerik
Furniture MyChair added to company FurnitureTelerik
Furniture NewChair added to company FurnitureTelerik
FurnitureTelerik - 1234567890 - 4 furnitures
Type: ConvertibleChair, Model: NewChair, Material: Plastic, Price: 80.00, Height: 1.00, Legs: 3, State: Normal
Type: Chair, Model: TestChair, Material: Leather, Price: 99.99, Height: 1.20, Legs: 5
Type: AdjustableChair, Model: MyChair, Material: Leather, Price: 111.56, Height: 0.80, Legs: 4
Type: Table, Model: SmallTable, Material: Wooden, Price: 123.40, Height: 0.50, Length: 0.45, Width: 0.65, Area: 0.2925
Furniture NewChair removed from company FurnitureTelerik
FurnitureTelerik - 1234567890 - 3 furnitures
Type: Chair, Model: TestChair, Material: Leather, Price: 99.99, Height: 1.20, Legs: 5
Type: AdjustableChair, Model: MyChair, Material: Leather, Price: 111.56, Height: 0.80, Legs: 4
Type: Table, Model: SmallTable, Material: Wooden, Price: 123.40, Height: 0.50, Length: 0.45, Width: 0.65, Area: 0.2925
Type: AdjustableChair, Model: MyChair, Material: Leather, Price: 111.56, Height: 0.80, Legs: 4
Furniture NewChair not found
Furniture MyChair removed from company FurnitureTelerik
Furniture SmallTable removed from company FurnitureTelerik
FurnitureTelerik - 1234567890 - 1 furniture
Type: Chair, Model: TestChair, Material: Leather, Price: 99.99, Height: 1.20, Legs: 5
```
