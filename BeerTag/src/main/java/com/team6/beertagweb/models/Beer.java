package com.team6.beertagweb.models;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "beer")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beer_id")
    private int id;

    @Size(min = 3, max = 60, message = "Been name must be between 3 and 60 symbols")
    @Column(name = "name")
    private String beerName;

    @Column(name = "brewery")
    @Size(min = 3, max = 60, message = "Been brewery must be between 3 and 60 symbols")
    private String brewery;

    @Column(name = "abv")
    private double abv;

    @Column(name = "description")
    @Size(min = 10, max = 255, message = "Description must be between 10 and 255 symbols")
    private String description;

    @Column(name = "picture_url")
    private String picture;

    @OneToOne
    @JoinColumn(name = "beer_origin_country_id")
    private Country country;

    @OneToOne
    @JoinColumn(name = "beer_style_id")
    private Style style;

    public Beer() {
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "beer_tags_relationship",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> beerTags;

    @Formula("(select avg(r.rating) from beer_rating r where r.beer_id_rating = beer_id)")
    private Double avg;

    public double getAvg() {

        return (avg == null ? 0 : avg);
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public List<Tag> getBeerTags() {
        return beerTags;
    }

    public void setBeerTags(List<Tag> beerTags) {
        this.beerTags = beerTags;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Beer(@Valid String beerName, String brewery, double abv, String description) {
        this.beerName = beerName;
        this.brewery = brewery;
        this.abv = abv;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
