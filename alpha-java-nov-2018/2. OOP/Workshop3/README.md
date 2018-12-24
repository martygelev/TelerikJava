# Telerik Academy Alpha

## General Description

Implement a journey and ticket tracking system for a famous travel agency called `Agency`. The application already accepts commands and outputs text for each submitted command, you just need to write the OOP. You can create different models (`Bus, Airplane, Train, Ticket, Journey`), as well as listing them. Make sure to follow all the good Object Orientated Programming practices and conventions that we have talked about during the lectures and don't let the length of this description intimidate you, read it carefully and start hacking!

## Architecture
Let's talk a bit about how the system works (you are already provided with all of this stuff, there is no need to implement it). There is an `EngineImpl` located in the `core` package that has a loop that cycles until the `Exit` command is submitted. With each cycle, it takes the input, passes it to the command parser that find the command with that name and executes it with those parameters. All commands are located in the `commands` package. The commands themselves use the `FactoryImpl` located in the `core.factories` package to create the needed objects. After the command executes, it returns a result message to the `EngineImpl` that prints it to the console and then the cycle beings again.

In the `EngineImpl`, there is a try-catch block that catches every possible exception type and prints the exception's message to the console. If you want to debug the program and see where an exception is thrown, I suggest you comment out that try-catch block during the debugging process. Don't forget to **uncomment it** back when you finish, otherwise your program will crash upon invalid input!

Do not bother reading the other classes, your focus should be on the `models` and `commands` packages, where you need to place the classes you create, using the provided interfaces in the `contracts` package or implement the commands which are not ready yet. The result from the execution of every command is printed on the console after each step, so please use the input one line at a time.

You also have a tests assembly with one class called `AgencyTests` and a folder with tests. Those are input/output tests and only verify if your program outputs the correct information, based on the input provided. Feel free to take a look in there, should you feel lost. You can either run the tests via IntelliJ, or manualy copy/paste the input in order to debug.

## Part 1 - Classes

Read the description `carefully` before you proceed to the code base. Read the code base `carefully` before you start implementing the down-mentioned requirements.

#### Validation Notes:

- All validation intervals are inclusive (closed).
- Try to stick to using only **IllegalArgumentException**.

#### Implement and validate the following:

- **Train** has: 
    - `PassangerCapacity` that is a number representing quantity in the interval of `[30, 150]`.
        - Exception message: `A train cannot have less than 30 passengers or more than 150 passengers.`
    - `Carts` that is a number representing quantity in the interval of `[1, 15]`.
        - Exception message: `A train cannot have less than 1 cart or more than 15 carts.`
    - `Type` that is a set of fixed values in the interval of `[Land, Air, Sea]`.
    - `PricePerKilometer` that is a number representing currency.
    - Should be convertable to **String** in the format:

```
Train ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Carts amount: VALUE
```

- **Airplane** has: 
    - `PassangerCapacity` that is a number representing quantity.
    - `Type` that is a set of fixed values in the interval of `[Land, Air, Sea]`.
    - `HasFreeFood` that is a boolean.
    - `PricePerKilometer` that is a number representing currency.
    - Should be convertable to **String** in the format:

```
Airplane ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
Has free food: VALUE
```
    
- **Bus** has: 
    - `PassangerCapacity` that is a number representing quantity in the interval of `[10, 50]`.
        - Exception message: `A bus cannot have less than 10 passengers or more than 50 passengers.`
    - `PricePerKilometer` that is a number representing currency.
    - `Type` that is a set of fixed values in the interval of `[Land, Air, Sea]`.
    - Should be convertable to **String** in the format:

```
Bus ----
Passenger capacity: VALUE
Price per kilometer: VALUE
Vehicle type: VALUE
```

- **Journey** has: 
    - `StartLocation` that is a string with length in the interval of `[5, 25]`.
        - Exception message: `The StartingLocation's length cannot be less than 5 or more than 25 symbols long.`
    - `Destination` that is a string with length in the interval of `[5, 25]`.
        - Exception message: `The Destination's length cannot be less than 5 or more than 25 symbols long.`
    - `Distance` that is a number representing quantity in the interval of `[5, 5000]`.
        - Exception message: `The Distance cannot be less than 5 or more than 5000 kilometers.`
    - `Vehicle` that is the vehicle used in the journey.
    - `CalculateTravelCosts()` that returns a currency calculated by:
        - Multiplying the `Distance` by the `Vehicle`'s price per kilometer.
    - Should be convertable to **String** in the format:

```
Journey ----
Start location: VALUE
Destination: VALUE
Distance: VALUE
Vehicle type: VALUE
Travel costs: VALUE
```

- **Ticket** has: 
    - `Journey` that is the journey the ticket is sold for.
    - `AdministrativeCosts` that is a number representing currency.
    - `CalculatePrice()` that returns a currency calculated by:
        - Multiplying the `AdministrativeCosts` by the `Journey`'s travel costs.
    - Should be convertable to **String** in the format:

```
Ticket ----
Destination: VALUE
Price: VALUE
```

- **Factory** has:
    - **createBus(...)** that needs to be implemented.
    - **createAirplane(...)** that needs to be implemented.
    - **createTrain(...)** that needs to be implemented.
    - **createJourney(...)** that needs to be implemented.
    - **createTicket(...)** that needs to be implemented.

#### Additional validations

The laws of physics and finances dictate that:

- A vehicle with `less than 1 passenger` or more than `800 passengers` cannot exist!
    - Exception message: `A vehicle with less than 1 passengers or more than 800 passengers cannot exist!`
- A vehicle with a price per kilometer `lower than $0.10` or `higher than $2.50` cannot exist!
    - Exception message: `A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!`

In your case, there is such a vehicle, but think about these rules more generally. This system could be extended in the future to accommodate more vehicles.

## Part 2 - Commands

**All commands are case insensitive, except their parameters!** Each command is represented in the code base as a separate class, that is invoked by the Engine. 

You are given a set of commands. The following are already implemented:
- **CreateBus** `[PassangerCapacity] [PricePerKilometer]` - Creates a new `Bus`.
- **CreateTrain** `[PassangerCapacity] [PricePerKilometer] [Carts]` - Creates a new `Train`.
- **CreateJourney** `[StartLocation] [Destination] [Distance] [VehicleID]` - Creates a new `Journey`.
- **ListJourneys** - Lists all stored journeys.
- **ListTickets** - Lists all stored tickets.

And these are the commands you need to implement yourself:
- **CreateAirplane** `[PassangerCapacity] [PricePerKilometer] [HasFreeFood]` - Creates a new `Airplane`.
- **CreateTicket** `[JourneyID] [AdministrativeCosts]` - Creates a new `Ticket`.
- **ListVehicles** - Lists all stored vehicles.

## Constraints
* You are allowed to create new and modify existing **classes, interfaces, enumerations and packages** in the `models` package.
* You are allowed to modify the **FactoryImpl** in the `core.factories` package.
* You are allowed to create and modify existing classes in the `core.commands` package. **(Careful with the names!)**
* You are allowed to add and remove usings from every file in the solution.
* **You are NOT allowed to modify any other existing interfaces!**
* **You are NOT allowed to modify any other existing classes, enumerations and packages!**