package com.team6.beertagweb.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    @Size(min = 2, max = 20, message = "Incorrect size for First Name. Min length 2, Max length 20")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 20, message = "Incorrect size for Last Name. Min length 2, Max length 20")
    private String lastName;

    @Column(name = "email")
    @Size(min = 8, max = 45, message = "Incorrect size for email. Min length 8, Max length 45")
    private String email;

    @Column(name= "avatar_url")
    private String avatar;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Login login;

    public User(){}

    public User (String firstName, String lastName, String email){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
