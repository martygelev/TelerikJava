package com.telerikacademy.cosmetics.core.contracts;

import java.util.List;

public interface Command {
    String getCommandName();

    List<String> getParameters();
}
