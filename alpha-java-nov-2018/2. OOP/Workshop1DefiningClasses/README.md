## Cosmetics shop - workshop (OOP - Classes exercise)

### Description
The shop already has a working Engine. You do not have to touch anything in it. Just use it.
Each product has **name, brand, price and gender** (men, women, unisex).
There are **categories** of products. Each **category** has **name** and products can be **added or removed**. The same product can be added to a category more than once. There is also a **shopping cart**. Products can be **added or removed** from it. The same product can be added to the shopping cart more than once. The shopping cart can calculate the **total price** of all products in it.

### Task
Your **task** is to **design an object-oriented class hierarchy** to model the cosmetics shop, **using the best practices for object-oriented design** (OOD) and **object-oriented programming** (OOP). Encapsulate correctly all fields and use validation whenever needed.

#### **Hint**: Use exceptions for validation i.e. research how to throw IllegalArgumentException.

#### 1. Categories
- Adding the same product to one category more than once is allowed.
- Minimum category name’s length length is 2 symbols and maximum is 15 symbols.
- Products in category should be sorted by brand in ascending order and then by price in descending order.  
- When removing product from category, if the product is not found you should throw an exception.
- Category’s print method should return text in the following format:


```
#Category: {category name}
 #Name Brand
 #Price: {price}
 #Gender: {genderType}
 ===
 #Name Brand
 #Price: {price}
 #Gender: {genderType}
 ===
```

```
#Category: Shampoos
 #No product in this category
```

#### 2.  Products
- Minimum product name’s length is 3 symbols and maximum is 10 symbols.
- Minimum brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be **"Men"**, **"Women"** or **"Unisex"**.

#### 3. Shopping cart.
- Adding the same product more than once is allowed.
- Do not check if the product exists, when removing it from the shopping cart.

### Constraints
- Look into the example below to get better understanding of the printing format.
- All number type fields should be printed “as is”, without any formatting or rounding.
- All properties in the above interfaces are mandatory (cannot be null or empty).
- If a null value is passed to some mandatory property, your program should throw a proper exception.

### Additional notes
- To simplify your work you are given an already built execution engine that executes a sequence of commands read from the console using the classes and interfaces in your project (see the Cosmetics-Skeleton folder).
- Please, put your classes in **cosmetics** package.
- Implement the CosmeticsFactory class in the **cosmetics.core.engine** package.

### Input example

```
CreateProduct MyMan Nivea 10.99 Men
CreateCategory Shampoos
AddToCategory Shampoos MyMan
AddToShoppingCart MyMan
ShowCategory Shampoos
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
```

### Output Example

```
Product with name MyMan was created!
Category with name Shampoos was created!
Product MyMan added to category Shampoos!
Product MyMan was added to the shopping cart!
#Category: Shampoos
 #MyMan Nivea
 #Price: $10.99
 #Gender: Men
 ===
$10.99 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
No product in shopping cart!
```

### Unit Tests

- You have been given unit tests to keep track off your progress.



## Step by step guide

#### **Hint**: You don't need to take care of the Engine class and the Main method but of course you could try to understand how they work.

#### **Hint**: Use the Unit tests whenever you finish a task.

**1.** You are given a skeleton of the Cosmetics shop. Please take a look at it carefully before you try to do anything. Try to understand all the classes and interfaces and how the engine works. (You should not touch the engine at all).

**2.** Just build the project and look at the errors.

**3.** The errors are in **Product** class
    - **Hint** (Encapsulate all the fields)

**4.** Now the build should be successful if everything is fine.

**5.** Think about the validations and what is not done in the constructor


**6.** Let's go and have a look to the CosmeticFactory class

- Implement the method **CreateProduct**. Look at the other methods for ideas.

- **HINT** Parse string to enum: 
- [HOW](https://stackoverflow.com/questions/7056959/convert-string-to-equivalent-enum-value)

**7.** Finish **ShoppingCart** class
- Initialize the collection!!!
- The other methods are just manipulating the collection
- Encapsulate it!

```
public ShoppingCart()
{
    productList = new ArrayList<Product>();
}
```

**8.** Finish **Category** class
- Initialize the collection!!!
- The other methods are just manipulating the collection

**9.** Implement **Print()** methods in both the **Category and Product** classes.

- The **Print()** method is not test with unit tests. Just check on the console the final result.

**10.** As you saw we don't need to look at the Engine class and the Main method  at all.

