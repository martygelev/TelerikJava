package com.telerikacademy.hms;

public class Patient extends User {
    private long patientId;
    private boolean insured;

    public Patient() {
        System.out.println("Default Patient constructor");
    }

    public Patient(long patientId, boolean insured) {
        this.patientId = patientId;
        this.insured = insured;

        System.out.println("Patient constructor with parameters");
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
