package hms;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount)
    {
        double[] payments = new double[2];
        HealthInsurancePlan patientPlan = patient.getInsurancePlan();

        return payments;
    }
}
