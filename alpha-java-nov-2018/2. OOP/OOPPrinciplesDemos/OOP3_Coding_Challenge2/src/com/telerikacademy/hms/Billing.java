package com.telerikacademy.hms;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        double coverage = 0;
        if (patientInsurancePlan != null) {
            coverage = patientInsurancePlan.getCoverage();
        }

        int discount = 20;
        if (patientInsurancePlan != null) {
            discount = patientInsurancePlan.getDiscount();
        }

        double coveredAmount = amount * coverage + discount;
        if (coveredAmount > amount) {
            coveredAmount = amount;
        }

        payments[0] = coveredAmount;
        payments[1] = amount - coverage;

        return payments;
    }

}