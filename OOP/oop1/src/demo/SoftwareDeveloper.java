package demo;

public class SoftwareDeveloper extends Person {
    private double salary;
    private String[] freeTime;
    private boolean drinking;

    public boolean isDrinking() {
        return drinking;
    }

    public void setisDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public String[] getFreeTime() {
        return freeTime;
    }

    private void setFreeTime(String[] freeTime) {
        this.freeTime = freeTime;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    protected SoftwareDeveloper(String firstName, String lastName, String email, int age, double salary) {
        super(firstName, lastName, email, age);
        setSalary(salary);
        freeTime= new String[0];
    }

    public SoftwareDeveloper(String firstName, String lastName, String email, int age, String phoneNumber,double salary,String[] freeTime) {
        super(firstName, lastName, email, age, phoneNumber);
        setSalary(salary);
        setFreeTime(freeTime);


    }

    public SoftwareDeveloper(String firstName, String lastName, String email, int age,
                             String phoneNumber, String country,double salary,String[] freeTime, boolean drinking) {
        super(firstName, lastName, email, age, phoneNumber, country);
        setSalary(salary);
        setFreeTime(freeTime);
        setisDrinking(drinking);

    }
}
