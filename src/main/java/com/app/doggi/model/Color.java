package com.app.doggi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Class representing a dog's color
 * @version 1.0
 */
@Entity
@Table(name = "COLOR")

public class Color {
    //Attributes
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "colors")
    @JsonIgnore
    private List<DogBreed> dogBreeds;



    //Access methods
    public List<DogBreed> getDogBreeds() {
        return dogBreeds;
    }

    public void setDogBreeds(List<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
