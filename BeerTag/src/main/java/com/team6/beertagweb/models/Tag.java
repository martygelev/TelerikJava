package com.team6.beertagweb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int id;

    @Column(name = "tag_content")
    private String tagTitle;

    @JsonIgnore
    @ManyToMany(mappedBy = "beerTags")
    private List<Beer> beerSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Beer> getBeerSet() {
        return beerSet;
    }

    public void setBeerSet(List<Beer> beerSet) {
        this.beerSet = beerSet;
    }

    public Tag(){
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

}
