package com.telerikacademy.agency.models.contracts;

public interface Ticket {
    double getAdministrativeCosts();

    Journey getJourney();

    double CalculatePrice();
}
