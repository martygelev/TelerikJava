package com.telerikacademy.agency;

import com.telerikacademy.agency.core.EngineImpl;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.core.factories.AgencyFactoryImpl;

public class Startup {
    public static void main(String[] args) {
        // Singleton design pattern
        // Ensures that there is only one instance of Engine in existence
        // Yo are already familiar with it, right?
        AgencyFactory factory = new AgencyFactoryImpl();
        Engine engine = new EngineImpl(factory);
        engine.start();
    }
}
