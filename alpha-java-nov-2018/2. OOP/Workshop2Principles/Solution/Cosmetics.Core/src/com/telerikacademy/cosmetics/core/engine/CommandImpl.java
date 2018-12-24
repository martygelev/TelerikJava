package com.telerikacademy.cosmetics.core.engine;

import com.telerikacademy.cosmetics.core.contracts.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandImpl implements Command {
    private static final char SPLIT_COMMAND_SYMBOL = ' ';

    private String commandName;
    private List<String> parameters;

    private CommandImpl(String input) {
        translateInput(input);
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        if (commandName == null || commandName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");

        }
        this.commandName = commandName;
    }

    @Override
    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("List of strings cannot be null.");
        }
        this.parameters = parameters;
    }

    public static Command parse(String input) {
        return new CommandImpl(input);
    }

    private void translateInput(String input) {
        int indexOfFirstSeparator = input.indexOf(SPLIT_COMMAND_SYMBOL);

        if (indexOfFirstSeparator < 0) {
            setCommandName(input);
            return;
        }

        setCommandName(input.substring(0, indexOfFirstSeparator));
        String[] lines = input.substring(indexOfFirstSeparator + 1).split(Character.toString(SPLIT_COMMAND_SYMBOL));
        ArrayList<String> actualParameters = new ArrayList<>();

        for (String s : lines) {
            if (!s.isEmpty())
                actualParameters.add(s);
        }

        setParameters(actualParameters);
    }
}
