package com.telerikacademy.hms;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        super(0.8, 40);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.07;
    }
}
