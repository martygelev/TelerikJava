package com.telerikacademy.refs;

import java.util.function.Consumer;

public class CarService {

    public void execute(Car car, Consumer<Car> c) {
        c.accept(car);
    }

    public void main() {

        final Mechanic mechanic = new Mechanic();
        Car car = new Car();

        // Using a lambda expression
        execute(car, c -> mechanic.fix(c));

        // Using a method reference
        execute(car, mechanic::fix);
    }

}

class Car {
    private int id;
    private String color;
    // More properties
    // And getter and setters

    public int getId() {
        return id;
    }
}

class Mechanic {
    public void fix(Car c) {
        System.out.println("Fixing car " + c.getId());
    }
}
