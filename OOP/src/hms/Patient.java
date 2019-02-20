package hms;

public class Patient extends User {
    private boolean insured;
    private HealthInsurancePlan insurancePlan;

    public HealthInsurancePlan getInsurancePlan() {

        return insurancePlan;

    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public boolean isInsured() {
        return insured;
    }

    private void setInsured(boolean insured) {
        this.insured = insured;
    }

    public Patient(long id, String firstName, String lastName, String gender, String email, boolean insured) {
        super(id, firstName, lastName, gender, email);
        setInsured(insured);

    }
}
