package demo;

public class Student extends Person {
    private int hoursPerDay;
    private String uniName;
    private double GPA;
    private boolean working;

    public void setWorking(boolean working) {
        this.working = working;
    }
    public boolean isWorking ()
    {
        return working;
    }

    public void setGPA(double GPA) {
        if (GPA<3.0)
        {
            System.out.println("To work with us your GPA must be at least 3.5!");
        }
        this.GPA = GPA;
    }

    public double getGPA() {
        return GPA;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        if (hoursPerDay<4)
        {
            System.out.println("You must study more! ");
        }
        this.hoursPerDay = hoursPerDay;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        if (uniName.length()<3)
        {
            throw new  IllegalArgumentException("Invalid name");
        }
        this.uniName = uniName;
    }

    protected Student(String firstName, String lastName, String email, int age,String uniName,double gpa) {
        super(firstName, lastName, email, age);
        setUniName(uniName);
        setGPA(gpa);
    }

    public Student(String firstName, String lastName, String email, int age, String phoneNumber,String uniName,double gpa) {
        super(firstName, lastName, email, age, phoneNumber);
        setUniName(uniName);
        setGPA(gpa);
    }

    public Student(String firstName, String lastName, String email, int age, String phoneNumber,
                   String country,String uniName ,double gpa, int hoursPerDay) {
        super(firstName, lastName, email, age, phoneNumber, country);
        setGPA(gpa);
        setUniName(uniName);
        setHoursPerDay(hoursPerDay);
    }
}
