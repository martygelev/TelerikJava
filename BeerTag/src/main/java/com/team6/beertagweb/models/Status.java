package com.team6.beertagweb.models;

import com.team6.beertagweb.models.enums.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusEnum name;

    public Status() {
    }

    public Status(StatusEnum name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(StatusEnum name) {
        this.name = name;
    }
}
