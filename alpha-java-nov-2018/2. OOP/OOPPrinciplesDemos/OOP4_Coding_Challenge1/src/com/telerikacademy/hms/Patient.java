package com.telerikacademy.hms;

public class Patient extends User {
    private boolean insured;

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
