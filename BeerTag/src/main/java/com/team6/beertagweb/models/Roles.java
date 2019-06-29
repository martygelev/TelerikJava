package com.team6.beertagweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team6.beertagweb.models.enums.RolesEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RolesEnum userType;

    @JsonIgnore
    @ManyToMany(mappedBy = "logins")
    private Set<Login> roles;

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolesEnum getUserType() {
        return userType;
    }

    public void setUserType(RolesEnum userType) {
        this.userType = userType;
    }
}
