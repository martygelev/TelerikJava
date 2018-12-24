package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.core.contracts.Command;
import com.telerikacademy.cosmetics.core.contracts.CosmeticsFactory;
import com.telerikacademy.cosmetics.core.contracts.Engine;
import com.telerikacademy.cosmetics.models.cart.ShoppingCartImpl;
import com.telerikacademy.cosmetics.models.common.GenderType;
import com.telerikacademy.cosmetics.models.common.UsageType;
import com.telerikacademy.cosmetics.models.contracts.*;
import com.telerikacademy.cosmetics.models.products.ShampooImpl;
import com.telerikacademy.cosmetics.models.products.ToothpasteImpl;

import java.util.*;
import java.util.stream.Collectors;

public final class CosmeticsEngine implements Engine {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";
    private static final String CATEGORY_EXISTS = "Category with name %s already exists!";
    private static final String CATEGORY_CREATED = "Category with name %s was created!";
    private static final String CATEGORY_DOES_NOT_EXIST = "Category %s does not exist!";
    private static final String PRODUCT_DOES_NOT_EXIST = "Product %s does not exist!";
    private static final String PRODUCT_ADDED_TO_CATEGORY = "Product %s added to category %s!";
    private static final String PRODUCT_REMOVED_CATEGORY = "Product %s removed from category %s!";
    private static final String SHAMPOO_ALREADY_EXIST = "Shampoo with name %s already exists!";
    private static final String SHAMPOO_CREATED = "Shampoo with name %s was created!";
    private static final String TOOTHPASTE_ALREADY_EXIST = "Toothpaste with name %s already exists!";
    private static final String TOOTHPASTE_CREATED = "Toothpaste with name %s was created!";
    private static final String PRODUCT_ADDED_TO_SHOPPING_CART = "Product %s was added to the shopping cart!";
    private static final String PRODUCT_DOES_NOT_EXIST_IN_SHOPPING_CART = "Shopping cart does not contain product with name %s!";
    private static final String PRODUCT_REMOVED_FROM_SHOPPING_CART = "Product %s was removed from the shopping cart!";
    private static final String TOTAL_PRICE_IN_SHOPPING_CART = "$%f total price currently in the shopping cart!";
    private static final CosmeticsEngine SINGLE_INSTANCE = new CosmeticsEngine();

    private final CosmeticsFactoryImpl factory;
    private final ShoppingCartImpl shoppingCart;
    private final Map<String, Category> categories;
    private final Map<String, Product> products;

    private CosmeticsEngine() {
        factory = new CosmeticsFactoryImpl();
        shoppingCart = new ShoppingCartImpl();
        categories = new HashMap<>();
        products = new HashMap<>();
    }

    public static CosmeticsEngine getInstance() {
        return SINGLE_INSTANCE;
    }

    public void start() {
        List commands = readCommands();
        List commandResult = processCommands(commands);
        printReports(commandResult);
    }

    private List<Command> readCommands() {
        List commands = new ArrayList<Command>();

        Scanner scanner = new Scanner(System.in);
        String currentLine = scanner.nextLine();

        while (currentLine != null && !currentLine.isEmpty()) {
            Command currentCommand = CommandImpl.parse(currentLine);
            commands.add(currentCommand);
            currentLine = scanner.nextLine();
        }

        return commands;
    }

    private List<String> processCommands(List<Command> commands) {
        List<String> reports = new ArrayList<>();

        for (Command command : commands) {
            try {
                String report = processSingleCommand(command);
                reports.add(report);
            } catch (Exception ex) {
                reports.add(ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString());
            }
        }

        return reports;
    }

    private String processSingleCommand(Command command) {
        switch (command.getCommandName()) {
            case "CreateCategory":
                String categoryName = command.getParameters().get(0);
                return createCategory(categoryName);

            case "AddToCategory":
                String categoryNameToAdd = command.getParameters().get(0);
                String productToAdd = command.getParameters().get(1);
                return addToCategory(categoryNameToAdd, productToAdd);

            case "RemoveFromCategory":
                String categoryNameToRemove = command.getParameters().get(0);
                String productToRemove = command.getParameters().get(1);
                return removeCategory(categoryNameToRemove, productToRemove);

            case "ShowCategory":
                String categoryToShow = command.getParameters().get(0);
                return showCategory(categoryToShow);

            case "CreateShampoo":
                String shampooName = command.getParameters().get(0);
                String shampooBrand = command.getParameters().get(1);
                double shampooPrice = Double.parseDouble(command.getParameters().get(2));
                GenderType shampooGender = getGender(command.getParameters().get(3));
                int shampooMilliliters = Integer.parseInt(command.getParameters().get(4));
                UsageType shampooUsage = getUsage(command.getParameters().get(5));
                return createShampoo(shampooName, shampooBrand, shampooPrice, shampooGender, shampooMilliliters, shampooUsage);

            case "CreateToothpaste":
                String toothpasteName = command.getParameters().get(0);
                String toothpasteBrand = command.getParameters().get(1);
                double toothpastePrice = Double.parseDouble(command.getParameters().get(2));
                GenderType toothpasteGender = getGender(command.getParameters().get(3));
                List<String> toothpasteIngredients = Arrays.stream(command.getParameters().get(4).trim().split(",")).collect(Collectors.toList());
                return createToothpaste(toothpasteName, toothpasteBrand, toothpastePrice, toothpasteGender, toothpasteIngredients);

            case "AddToShoppingCart":
                String productToAddToCart = command.getParameters().get(0);
                return addToShoppingCart(productToAddToCart);

            case "RemoveFromShoppingCart":
                String productToRemoveFromCart = command.getParameters().get(0);
                return removeFromShoppingCart(productToRemoveFromCart);

            case "TotalPrice":
                return shoppingCart.getProductList() != null && shoppingCart.getProductList().size() > 0 ?
                        String.format(TOTAL_PRICE_IN_SHOPPING_CART, shoppingCart.totalPrice()) :
                        "No product in shopping cart!";

            default:
                return String.format(INVALID_COMMAND, command.getCommandName());
        }
    }

    private void printReports(List<String> reports) {
        StringBuilder output = new StringBuilder();

        for (String report : reports) {
            output.append(report);
            output.append(System.getProperty("line.separator"));
        }

        System.out.print(output.toString());
    }

    private String createCategory(String categoryName) {
        if (categories.containsKey(categoryName)) {
            return String.format(CATEGORY_EXISTS, categoryName);
        }

        Category category = factory.createCategory(categoryName);
        categories.put(categoryName, category);

        return String.format(CATEGORY_CREATED, categoryName);
    }

    private String addToCategory(String categoryNameToAdd, String productToAdd) {
        if (!categories.containsKey(categoryNameToAdd)) {
            return String.format(CATEGORY_DOES_NOT_EXIST, categoryNameToAdd);
        }

        if (!products.containsKey(productToAdd)) {
            return String.format(PRODUCT_DOES_NOT_EXIST, productToAdd);
        }

        Category category = categories.get(categoryNameToAdd);
        Product product = products.get(productToAdd);

        category.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_CATEGORY, productToAdd, categoryNameToAdd);
    }

    private String removeCategory(String categoryNameToRemove, String productToRemove) {
        if (!categories.containsKey(categoryNameToRemove)) {
            return String.format(CATEGORY_DOES_NOT_EXIST, categoryNameToRemove);
        }

        if (!products.containsKey(productToRemove)) {
            return String.format(PRODUCT_DOES_NOT_EXIST, productToRemove);
        }

        Category category = categories.get(categoryNameToRemove);
        Product product = products.get(productToRemove);

        category.removeProduct(product);

        return String.format(PRODUCT_REMOVED_CATEGORY, productToRemove, categoryNameToRemove);
    }

    private String showCategory(String categoryToShow) {
        if (!categories.containsKey(categoryToShow)) {
            return String.format(CATEGORY_DOES_NOT_EXIST, categoryToShow);
        }

        Category category = categories.get(categoryToShow);

        return category.print();
    }

    private String createShampoo(String shampooName, String shampooBrand, double shampooPrice, GenderType shampooGender, int shampooMilliliters, UsageType shampooUsage) {
        if (products.containsKey(shampooName)) {
            return String.format(SHAMPOO_ALREADY_EXIST, shampooName);
        }

        ShampooImpl shampoo = factory.createShampoo(shampooName, shampooBrand, shampooPrice, shampooGender, shampooMilliliters, shampooUsage);
        products.put(shampooName, (Product) shampoo);

        return String.format(SHAMPOO_CREATED, shampooName);
    }

    private String createToothpaste(String toothpasteName, String toothpasteBrand, double toothpastePrice, GenderType toothpasteGender, List<String> toothpasteIngredients) {
        if (products.containsKey(toothpasteName)) {
            return String.format(TOOTHPASTE_ALREADY_EXIST, toothpasteName);
        }

        ToothpasteImpl toothpaste = factory.createToothpaste(toothpasteName, toothpasteBrand, toothpastePrice, toothpasteGender, toothpasteIngredients);
        products.put(toothpasteName, (Product) toothpaste);

        return String.format(TOOTHPASTE_CREATED, toothpasteName);
    }

    private String addToShoppingCart(String productName) {
        if (!products.containsKey(productName)) {
            return String.format(PRODUCT_DOES_NOT_EXIST, productName);
        }

        Product product = products.get(productName);
        shoppingCart.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_SHOPPING_CART, productName);
    }

    private String removeFromShoppingCart(String productName) {
        if (!products.containsKey(productName)) {
            return String.format(PRODUCT_DOES_NOT_EXIST, productName);
        }

        Product product = products.get(productName);

        if (!shoppingCart.containsProduct(product)) {
            return String.format(PRODUCT_DOES_NOT_EXIST_IN_SHOPPING_CART, productName);
        }

        shoppingCart.removeProduct(product);

        return String.format(PRODUCT_REMOVED_FROM_SHOPPING_CART, productName);
    }

    private GenderType getGender(String genderAsString) {
        return GenderType.valueOf(genderAsString);
    }

    private UsageType getUsage(String usageAsString) {
        return UsageType.valueOf(usageAsString);
    }
}
