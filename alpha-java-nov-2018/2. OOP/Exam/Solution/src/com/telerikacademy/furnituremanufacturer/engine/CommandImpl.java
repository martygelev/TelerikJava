package com.telerikacademy.furnituremanufacturer.engine;

import com.telerikacademy.furnituremanufacturer.interfaces.engine.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandImpl implements Command {
    private static final String NULL_OR_EMPTY_NAME_ERROR_MESSAGE = "Name cannot be null or empty";
    private static final String NULL_COLLECTION_OF_PARAMETERS = "Collection of parameters cannot be null";
    private static final char SPLIT_COMMAND_SYMBOL = ' ';

    private String name;
    private List<String> parameters;

    private CommandImpl(String input) {
        parameters = new ArrayList<>();
        translateInput(input);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getParameters() {
        return new ArrayList<>(parameters);
    }

    static Command parse(String input) {
        return new CommandImpl(input);
    }

    private void translateInput(String input) {
        int indexOfFirstSeparator = input.indexOf(SPLIT_COMMAND_SYMBOL);

        setName(input.substring(0, indexOfFirstSeparator));
        setParameters(Arrays.asList(input.substring(indexOfFirstSeparator + 1).split(" ")));
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    private void setParameters(List<String> parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException(NULL_COLLECTION_OF_PARAMETERS);
        }
        this.parameters = new ArrayList<>(parameters);
    }
}
