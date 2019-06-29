package com.team6.beertagweb.models;

import com.team6.beertagweb.models.enums.RolesEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "login_id")
    private int id;

    @Column(name = "username_login")
    private String username;


   @Column(name = "password")
   private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "login_userRoles",
            joinColumns = @JoinColumn(name = "login_id"),
            inverseJoinColumns = @JoinColumn(name= "role_id")
    )
    private Set<Roles> logins;


    public Set<Roles> getLogins() {
        return logins;
    }

    public void setLogins(Set<Roles> logins) {
        this.logins = logins;
    }

    public Login() {
    }

    public Login (String username, String password, RolesEnum rolesEnum){
        setUsername(username);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
