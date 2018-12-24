package com.telerikacademy.hms;

public class SilverPlan extends HealthInsurancePlan {
    public SilverPlan() {
        super(0.7, 30);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary * 0.06;
    }
}
