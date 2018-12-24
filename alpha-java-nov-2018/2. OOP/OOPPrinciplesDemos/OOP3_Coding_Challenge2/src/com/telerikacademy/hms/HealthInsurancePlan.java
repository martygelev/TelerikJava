package com.telerikacademy.hms;

public class HealthInsurancePlan {
    private double coverage;
    private int discount;
    private String offeredBy;

    public HealthInsurancePlan(double coverage, int discount) {
        setCoverage(coverage);
        setDiscount(discount);
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        if (coverage < 0 || coverage > 1) {
            throw new IllegalArgumentException();
        }
        this.coverage = coverage;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0) {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

    public String getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(String offeredBy) {
        this.offeredBy = offeredBy;
    }
}