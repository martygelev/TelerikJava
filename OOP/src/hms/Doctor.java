package hms;

public class Doctor extends Staff {
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    private void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(long id, String firstName, String lastName, String gender, String email
            , int yearsOfExperience, double salary, String description, String specialization) {
        super(id, firstName, lastName, gender, email, yearsOfExperience, salary, description);
        setSpecialization(specialization);
    }
}
