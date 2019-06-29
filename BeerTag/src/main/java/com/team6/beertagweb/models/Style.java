package com.team6.beertagweb.models;

import com.team6.beertagweb.models.enums.BeerStyleEnum;

import javax.persistence.*;

@Entity
@Table(name = "beer_styles")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "styles_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "style_type")
    private BeerStyleEnum typeOfStyle;

    public Style() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BeerStyleEnum getTypeOfStyle() {
        return typeOfStyle;
    }

    public void setTypeOfStyle(BeerStyleEnum typeOfStyle) {
        this.typeOfStyle = typeOfStyle;
    }
}