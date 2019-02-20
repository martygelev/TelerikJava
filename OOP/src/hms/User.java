package hms;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;

    public User(long id, String firstName, String lastName, String gender, String email) {
        setId(id);
        setFirstName(firstName);
        setGender(gender);
        setLastName(lastName);
        setEmail(email);

    }

    private void setId(long id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    protected long getId() {
        return id;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected String getGender() {
        return gender;
    }

    protected String getEmail() {
        return email;
    }
}
