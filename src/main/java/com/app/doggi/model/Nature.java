package com.app.doggi.model;

import javax.persistence.*;

/**
 * Class representing a dog's nature
 * @version 1.0
 */
@Entity
@Table(name = "NATURE")
public class Nature {
    //Attributes
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    //Access methods
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
