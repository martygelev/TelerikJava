package com.telerikacademy.refs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ShipmentService{
    public static void main(String[] args) {
        Supplier<Shipment> s = Shipment::new;
        Shipment shipment = s.get();

        Function<Integer, Shipment> f = Shipment::new;
        shipment = f.apply(100);

        BiFunction<Integer, Integer, Shipment> bf = Shipment::new;
        shipment = bf.apply(100, 2);

        Shipment.TriFunction<Integer, Integer, Boolean, Shipment> tf = Shipment::new;
        shipment = tf.apply(100,2, true);
    }
}

class Shipment {
    private int weight;
    private int quantity;
    private boolean flag;

    public Shipment() {
        weight = 0;
        quantity = 0;
        flag = false;
    }

    public Shipment(int weight){
        this.weight = weight;
        quantity = 1;
        flag = false;
    }

    public Shipment(int weight, int quantity){
        this.weight = weight;
        this.quantity = quantity;
        flag = false;
    }

    public Shipment(int weight, int quantity, boolean flag)
    {
        this(weight, quantity);
        this.flag = flag;
    }

    public double calculateWeight() {
        return weight * quantity;
    }

    public List<Double> calculateOnShipments(List<Shipment> l, Function<Shipment, Double> f) {

        List<Double> results = new ArrayList<>();
        for (Shipment s : l) {
            results.add(f.apply(s));
        }

        return results;
    }

    public void doJob() {
        List<Shipment> shipments = new ArrayList<>();

        // Using a lambda expression
        calculateOnShipments(shipments, s -> s.calculateWeight());

        // Using a method reference
        calculateOnShipments(shipments, Shipment::calculateWeight);


    }

    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}