package com.app.doggi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a canine breed.
 * @version 1.o
 */
@Entity
@Table(name = "DOG_BREED")
public class DogBreed {

    //Atrtibutes
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "WEIGHT", nullable = false)
    private double weight;
    @Column(name = "HEIGHT", nullable = false)
    private double height;
    @Column(name = "LIFE_EXPECTANCY", nullable = false)
    private int lifeExpectancy;



    @JoinTable(
            name = "DOGBREED_COLOR",
            joinColumns = @JoinColumn(name = "FK_DOG_BREED", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_COLOR", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Color> colors;

    @JoinTable(
            name = "DOGBREED_NATURE",
            joinColumns = @JoinColumn(name = "FK_DOG_BREED", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_NATURE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Nature> natures;

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

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Nature> getNatures() {
        return natures;
    }

    public void setNatures(List<Nature> natures) {
        this.natures = natures;
    }

    /**
     * Method to add a new color to dog breed
     * @param color
     */
    public void addColor(Color color){
        if(this.colors == null){
            this.colors = new ArrayList<>();
        }
        this.colors.add(color);
    }

    /**
     * Method to add a new nature to dog breed
     * @param nature
     */
    public void addNature(Nature nature){
        if(this.natures == null){
            this.natures= new ArrayList<>();
        }
        this.natures.add(nature);
    }
}
