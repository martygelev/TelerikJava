package com.telerikacademy.agency.models.contracts;

public interface Ticket extends Printable{
    double getAdministrativeCosts();

    Journey getJourney();

    double calculatePrice();
}
