package com.app.doggi.dtos.stdin;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class DogBreedStdInDto {

    //Atrtibutes

    @Size(max = 45, min=3, message="The name must be between 3 and 45 characters.")
    @Pattern(regexp = "[a-zA-z]+", message="The name can only have characters of the alphabet.")
    private String name;

    @Min(value = 1 ,message = "The weight must be greater than 1 kg." )
    @Max(value = 200 ,message = "The weight must not be greater than 200 kg." )
    private Double weight;

    @Min(value = 30 ,message = "The height must be greater than 30 cms." )
    @Max(value = 200 ,message = "The height must not be greater than 200 cms." )
    private Double height;

    @Min(value = 1 ,message = "The life expectancy must be greater than 1 year." )
    @Max(value = 100 ,message = "The weight must not be greater than 100 years" )
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
