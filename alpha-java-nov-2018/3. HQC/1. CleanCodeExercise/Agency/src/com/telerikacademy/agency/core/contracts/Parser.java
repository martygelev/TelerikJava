package com.telerikacademy.agency.core.contracts;

import com.telerikacademy.agency.commands.contracts.Command;

import java.util.List;

public interface Parser {
    Command parseCommand(String fullCommand);

    List<String> parseParameters(String fullCommand);
}
