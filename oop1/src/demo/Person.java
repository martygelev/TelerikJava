package demo;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int age;
    private String country;

    protected Person(String firstName, String lastName, String email, int age)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAge(age);
    }

    public Person (String firstName, String lastName, String email, int age, String phoneNumber)
    {
        this(firstName,lastName,email,age);
        setPhoneNumber(phoneNumber);
    }
    public Person(String firstName, String lastName, String email, int age, String phoneNumber, String country)
    {
        this(firstName,lastName, email, age,phoneNumber);
        setCountry(country);
    }

    protected String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length()<3 || firstName.length()>11)
        {
            throw new IllegalArgumentException("First name length must be between 3 and 11 symbols! \n Please enter your name again: ");
        }
        this.firstName = firstName;
    }

    protected String getLastName() {

        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length()<3 || lastName.length()>11)
        {
            throw new IllegalArgumentException("Last name length must be between 3 and 11 symbols! \n Please enter your name again: ");
        }
        this.lastName = lastName;
    }

    protected String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (!email.contains("@")|| !email.contains(".") || email.length()<10)
        {
            throw new IllegalArgumentException("Invalid email!");
        }
        this.email = email;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length()!=10)
        {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    protected int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age<0 || age>110)
        {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    protected String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country;
    }
}
