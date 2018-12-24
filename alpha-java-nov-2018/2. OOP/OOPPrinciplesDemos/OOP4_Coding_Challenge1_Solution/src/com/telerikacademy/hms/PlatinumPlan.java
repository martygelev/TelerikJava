package com.telerikacademy.hms;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan() {
        super(0.9, 50);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.08;
    }
}
