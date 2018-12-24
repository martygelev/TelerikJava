package com.telerikacademy.furnituremanufacturer.interfaces.engine;

import java.util.List;

public interface Command {

    String getName();

    List<String> getParameters();
}
