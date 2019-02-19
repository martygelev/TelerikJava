package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Journey;

import java.util.Arrays;
import java.util.List;

public class ListJourneysCommand implements Command {
    private final AgencyFactory factory;
    private final Engine engine;

    public ListJourneysCommand(AgencyFactory factory, Engine engine) {
        this.factory = factory;
        this.engine = engine;
    }

    public String execute(List<String> parameters) {
        List<Journey> journeys = engine.getJourneys();

        if (journeys.size() == 0) {
            return "There are no registered journeys.";
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < journeys.size(); i++) {
            sb.append(journeys.get(i).print());
            if (i < journeys.size() - 1) {
                sb.append("\n####################\n");
            }
        }
        return sb.toString();
    }
}
