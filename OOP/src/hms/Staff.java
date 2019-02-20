package hms;

public class Staff extends User {
    private int yearsOfExperience;
    private String description;
    private double salary;

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    private void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff(long id, String firstName, String lastName, String gender, String email, int yearsOfExperience, double salary, String description) {
        super(id, firstName, lastName, gender, email);
        setYearsOfExperience(yearsOfExperience);
        setDescription(description);
        setSalary(salary);
    }
}
