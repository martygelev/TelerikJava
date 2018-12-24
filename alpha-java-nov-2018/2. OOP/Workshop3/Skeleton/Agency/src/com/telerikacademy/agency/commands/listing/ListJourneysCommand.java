package com.telerikacademy.agency.commands.listing;

import com.telerikacademy.agency.commands.contracts.Command;
import com.telerikacademy.agency.core.contracts.Engine;
import com.telerikacademy.agency.core.factories.AgencyFactory;
import com.telerikacademy.agency.models.contracts.Journey;

import java.util.ArrayList;
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

        List<String> listJourneys = new ArrayList<>();
        for (Journey journey : journeys) {
            listJourneys.add(journey.toString());
        }

        return String.join("####################" + System.lineSeparator(), listJourneys).trim();
    }
}
