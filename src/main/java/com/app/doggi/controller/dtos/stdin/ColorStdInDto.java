package com.app.doggi.controller.dtos.stdin;

/**
 * Class representing a color dto
 * @version 1.0
 */
public class ColorStdInDto {

    //Attributes
    private Long id;


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