package com.app.doggi.stdout;

import javax.persistence.Column;
import javax.persistence.Id;

public class DogBreedStdOutDto {
    //Atrtibutes
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "WEIGHT", nullable = false)
    private double weight;
    @Column(name = "HEIGHT", nullable = false)
    private double height;
    @Column(name = "LIFE_EXPECTANCY", nullable = false)
    private int lifeExpectancy;

    //Acces methods

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
}
