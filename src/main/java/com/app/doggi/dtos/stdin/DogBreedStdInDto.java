package com.app.doggi.dtos.stdin;


import com.app.doggi.model.Color;
import com.app.doggi.model.Nature;

import java.util.List;

public class DogBreedStdInDto {

    //Atrtibutes

    private String name;

    private Double weight;

    private Double height;

    private Integer lifeExpectancy;

    private List<Long> dogBreedColors;

    private List<Long> dogBreedNatures;


    //Access methods

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public List<Long> getDogBreedColors() {
        return dogBreedColors;
    }

    public void setDogBreedColors(List<Long> dogBreedColors) {
        this.dogBreedColors = dogBreedColors;
    }

    public List<Long> getDogBreedNatures() {
        return dogBreedNatures;
    }

    public void setDogBreedNatures(List<Long> dogBreedNatures) {
        this.dogBreedNatures = dogBreedNatures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}
