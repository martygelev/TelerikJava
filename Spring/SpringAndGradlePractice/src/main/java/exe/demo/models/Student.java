package exe.demo.models;

import javax.validation.constraints.Size;

public class Student {

    private int id;

    @Size(min = 3, max = 10, message = "The min length of First Name must be 3")
    private String firstName;
    @Size(min = 3, max = 10, message = "The min length of Last Name must be 3")

    private String lastName;

    public Student(int id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
