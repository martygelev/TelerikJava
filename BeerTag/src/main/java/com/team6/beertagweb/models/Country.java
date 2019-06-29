package com.team6.beertagweb.models;

import com.team6.beertagweb.models.enums.OriginCountryEnum;

import javax.persistence.*;

@Entity
@Table(name = "beer_origin_country")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_code")
    private OriginCountryEnum name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(OriginCountryEnum name) {
        this.name = name;
    }
}


