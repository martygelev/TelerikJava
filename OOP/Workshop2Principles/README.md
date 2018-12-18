## Cosmetics shop - workshop (OOP - Principles exercise)

### Description
The shop already has a working Engine. You do not have to touch anything in it. Just use it.

There should be two types of products for now, Shampoos and Toothpastes. 
- Each Shampoo has **name, brand, price, gender, milliliters, usage**. 
- Each Toothpaste has **name, brand, price, gender, ingredients**.

### Task
Your **task** is to **design an object-oriented class hierarchy** (only two fo now) to model the cosmetics shop, **using the best practices for object-oriented design** (OOD) and **object-oriented programming** (OOP). Encapsulate correctly all fields and use validation whenever needed.

#### 1. ShampooImpl 
- Implements Shampoo
- It has name, brand, price, gender, milliliters, usage
- Minimum shampoo name’s length is 3 symbols and maximum is 10 symbols.
- Minimum shampoo brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.
- Milliliters are not negative number
- Usage type can be **"EveryDay"** or **"Medical"**

#### 2. ToothpasteImpl
- Implements Toothpaste
- It has name, brand, price, gender, ingredients
- Minimum toothpaste name’s length is 3 symbols and maximum is 10 symbols.
- Minimum toothpaste brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.
- Ingredients are comma separated values

#### 3. Interfaces
- In the skeleton there are all the needed interfaces. **You must use them all** in order to achieve the best OOP design.

### Constraints
- Look into the example below to get better understanding of the printing format.
- All number type fields should be printed “as is”, without any formatting or rounding.
- All properties in the above interfaces are mandatory (cannot be null or empty).
- If a null value is passed to some mandatory property, your program should throw a proper exception.

### Additional notes
- To simplify your work you are given an already built execution engine that executes a sequence of commands read from the console using the classes and interfaces in your project (see the Cosmetics-Skeleton folder).
- Please, put your classes in **cosmetics.models** package.
- Implement the CosmeticsFactoryImpl class in the **cosmetics.core.engine**.

### Input example

```
CreateShampoo MyMan Nivea 10.99 Men 1000 EveryDay
CreateToothpaste White Colgate 10.99 Men calcium,fluorid
CreateCategory Shampoos
CreateCategory Toothpastes
AddToCategory Shampoos MyMan
AddToCategory Toothpastes White
AddToShoppingCart MyMan
AddToShoppingCart White
ShowCategory Shampoos
ShowCategory Toothpastes
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
```

### Output Example

```
Shampoo with name MyMan was created!
Toothpaste with name White was created!
Category with name Shampoos was created!
Category with name Toothpastes was created!
Product MyMan added to category Shampoos!
Product White added to category Toothpastes!
Product MyMan was added to the shopping cart!
Product White was added to the shopping cart!
#Category: Shampoos
#MyMan Nivea
 #Price: $10.99
 #Gender: Men
 #Milliliters: 1000
 #Usage: EveryDay
 ===
#Category: Toothpastes
#White Colgate
 #Price: $10.99
 #Gender: Men
 #Ingredients: calcium, fluorid
 ===
$21.98 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
$10.99 total price currently in the shopping cart!
```

### Unit Tests

- You are given unit tests to keep track of your progress.

## Step by step guide

#### **Hint**: You don't need to take care of the Engine class and the Main method but of course you could try to understand how they work.

#### **Hint**: Use the Unit tests whenever you finish a task.

**1.** You are given a skeleton of the Cosmetics shop. Please take a look at it carefully before you try to do anything. Try to understand all the classes and interfaces and how the engine works. (You should not touch the engine at all).

**2.** Just build the project and look at the errors.

**3.** Validate all the fields. Yes, again :)

**4.** Implement all the interfaces. 
- Look at the Contracts folder in Cosmetics workspace and decide how to use any of the interfaces there.

**5.** Let's go and have a look to the CosmeticFactoryImpl class

- Implement all the methods. You already know what to do here.
- But decide on the return types of the methods.
    - Do you think you could improve something?

**6.** Take a look at ShoppingCart interface and put the methods you need there.


**7.** Did you notice the repeating code in the Shampoo and Toothpaste classes. What could you do in order to avoid it?

**8.** **Print()** method FTW

**9.** **ADVANCED TASK** 
- Implement new product and its creation in the engine class. 
- Cream (name, brand, price, gender, scent)
    - name minimum 3 symbols and maximum 15
    - brand minimum 3 symbols and maximum 15
    - price greater than zero
    - gender (men, women, unisex)
    - scent (lavender, vanilla, rose)
- Implement product creation in the Factory and the Engine
    - Just look at the other products
- Test it if it works correctly

