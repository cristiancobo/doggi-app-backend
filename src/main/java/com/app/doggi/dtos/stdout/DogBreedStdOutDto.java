package com.app.doggi.dtos.stdout;

import com.app.doggi.model.Color;
import com.app.doggi.model.Nature;

import java.util.ArrayList;
import java.util.List;

public class DogBreedStdOutDto {
    //Atrtibutes

    private String name;

    private double weight;

    private double height;

    private int lifeExpectancy;

    private List<Color> dogBreedColors;

    private List<Nature> dogBreedNatures;

    //Acces methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public List<Color> getDogBreedColors() {
        return dogBreedColors;
    }

    public void setDogBreedColors(List<Color> dogBreedColors) {
        this.dogBreedColors = dogBreedColors;
    }

    public List<Nature> getDogBreedNatures() {
        return dogBreedNatures;
    }

    public void setDogBreedNatures(List<Nature> dogBreedNatures) {
        this.dogBreedNatures = dogBreedNatures;
    }

    public void addColor(Color color){
        if(this.dogBreedColors == null){
            this.dogBreedColors = new ArrayList<>();
        }
        this.dogBreedColors.add(color);
    }

    public void addNature(Nature nature){
        if(this.dogBreedNatures == null){
            this.dogBreedNatures = new ArrayList<>();
        }
        this.dogBreedNatures.add(nature);
    }
}
